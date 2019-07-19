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

        Goal goal1 = new Goal("goal1", "contentofgoal1");
        Goal goal2 = new Goal("goal2", "contentofgoal2");

        //testing

        Goal goalX = new Goal("goal1", "contentofgoal1");
        Goal goalX2 = new Goal("goal2", "contentofgoal2");

        //tests^^^

        //goalsList.add(goal1);
        //goalsList.add(goal2);

        LoadGoals();

        for (int i = 0; i < goalsList.size(); i++)
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
        int nbOfGoals = 0;
        try{
            URL url = getClass().getResource("Goals_data.csv");
            CSVReader reader = new CSVReader(new FileReader(new File(url.toURI()).getAbsolutePath()));
            String [] line;
            //skip the first row (column headers)
            reader.readNext();
            while ((line = reader.readNext()) != null) {
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

                Goal goal = new Goal(goalName, goalContent, goalIsDone);
                goalsList.add(goal);
                nbOfGoals++;
            }
        } catch(IOException | URISyntaxException e){
            System.out.println("Failure! Something went wrong");
            e.printStackTrace();
        }
        System.out.println("Success! Number of loaded quotes: " + nbOfGoals);
    }
}
