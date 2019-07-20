package sample;

import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import com.opencsv.CSVReader;


public class QuoteWindow {

    private GridPane quotePane = new GridPane();
    private String quote;
    private ArrayList<String> quoteList = new ArrayList<>();

    public QuoteWindow()
    {

        LoadQuotes();
        quote = "\"" + quoteList.get(2) + "\"";
        Label quoteLabel = new Label(quote); //have to find another way to choose the quote, it's arbitrary here


        quotePane.add(quoteLabel, 1 , 1);
        quotePane.setMinSize(100, 75);


    }


    public GridPane GetPane()
    {
        return quotePane;
    }

    private void LoadQuotes() {
        System.out.print("Begin loading quote dataset...");
        int nbOfQuotes = 0;
        try{
            URL url = getClass().getResource("\\Data\\Quote_data.csv");  //finds the csv file
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath())); // initialises the reader to the file
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
