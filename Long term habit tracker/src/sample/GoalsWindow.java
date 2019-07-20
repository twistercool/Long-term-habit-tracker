package sample;

import com.opencsv.CSVReader;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import javafx.scene.control.*;

public class GoalsWindow {

    private GridPane pane = new GridPane();
    private ArrayList<Goal> goalsList = new ArrayList<>();


    public GoalsWindow()
    {

        LoadGoals(); //loads goals (duh)

        for (int i = 0; i < goalsList.size(); i++)  //for all goals in goalsList, display them in the gridpane
        {
            Goal goal = goalsList.get(i);
            Label nameLabel = new Label(goal.GetName());
            Label contentLabel = new Label(goal.GetContent());
            Label isDoneLabel = new Label();
            if (goal.GetIsDone())
            {
                isDoneLabel.setText("done");
            }
            else {
                isDoneLabel.setText("NOT done");
            }
            pane.add(nameLabel, 1, i);
            pane.add(contentLabel, 2, i);
            pane.add(isDoneLabel, 3, i);
        }
    }



    public GridPane GetPane()
    {
        return pane;
    }

    public ArrayList<Goal> GetGoals()
    {
        return goalsList;
    }

    public void LoadGoals() {
        System.out.print("Begin loading quote goals...");
        int nbOfGoals = 0; //for counting the loaded goals
        try{
            URL url = getClass().getResource("Goals_data.csv");  //finds the csv file
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath())); // initialises the reader to the file
            String [] line; //array of string of a single line in the csv file
            reader.readNext();  //skip the first row (column headers)
            while ((line = reader.readNext()) != null) {  //if the line is empty it stops reading
                String goalName = line[0];
                String goalContent= line[1];
                String goalIsDoneString = line[2];
                boolean goalIsDone = false;
                if (goalIsDoneString.equals("TRUE"))
                {
                    goalIsDone = true;
                }
                else if (goalIsDoneString.equals("FALSE")) {
                    goalIsDone = false;
                }

                Goal goal = new Goal(goalName, goalContent, goalIsDone);  //creates a goal with the info from a line in the csv file
                goalsList.add(goal);  //adds the goal to goalsList
                nbOfGoals++;   //counts the nb of goals loaded
            }
        } catch(IOException | URISyntaxException e){   //exception handling
            System.out.println("Failure! Something went wrong");
            e.printStackTrace();
        }
        System.out.println("Success! Number of loaded goals: " + nbOfGoals);
    }
}
