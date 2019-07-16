package sample;

import javafx.scene.layout.GridPane;
import java.util.*;
import javafx.scene.control.*;

public class GoalsWindow {

    private GridPane pane = new GridPane();
    private ArrayList<Goal> goalsList = new ArrayList<>();


    public GoalsWindow()
    {


        //testing
        Goal goal1 = new Goal("goal1", "contentofgoal1");
        Goal goal2 = new Goal("goal2", "contentofgoal2");
        //

        goalsList.add(goal1);
        goalsList.add(goal2);

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
}
