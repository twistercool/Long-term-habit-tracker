package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import com.opencsv.CSVReader;


public class QuoteWindow {

    private GridPane quotePane = new GridPane();
    private String quote = "";
    private ArrayList<String> quoteList = new ArrayList();

    public QuoteWindow()
    {

        //quote = "example of a quote, just for testing purposes";
        //quote = "\"" + quote + "\"";


        LoadQuotes();
        quote = quoteList.get(2);
        Label quoteLabel = new Label(quote); //have to find another way to choose the quote, it's arbitrary here


        quotePane.add(quoteLabel, 1 , 1);
        quotePane.setMinSize(100, 75);


    }


    public GridPane GetPane()
    {
        return quotePane;
    }

    public void LoadQuotes() {
        System.out.print("Begin loading quote dataset...");
        int nbOfQuotes = 0;
        try{
            URL url = getClass().getResource("Quote_data.csv");
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));
            String [] line;
            //skip the first row (column headers)
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                String currentQuote = line[0];
                quoteList.add(currentQuote);
                nbOfQuotes++;
            }
        } catch(IOException | URISyntaxException e){
            System.out.println("Failure! Something went wrong");
            e.printStackTrace();
        }
        System.out.println("Success! Number of loaded quotes: " + nbOfQuotes);
    }

}
