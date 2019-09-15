package sample;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        currentGoal(primaryStage);
    }

    public void currentGoal (Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setMinSize(50, 15);
        primaryStage.setTitle("Hello World");

        //sets the top of the borderpane
        Label titleLabel = new Label("GOALS");
        StackPane goalsTopPane = new StackPane(titleLabel);
        root.setTop(goalsTopPane);

        //sets the center of the borderpane
        QuoteWindow quoteWindow = new QuoteWindow();
        root.setCenter(quoteWindow.GetPane());

        //sets the bottom of the borderpane
        GoalsWindow goalWindow = new GoalsWindow();
        root.setBottom(goalWindow.GetPane());

        // sets the event window
        EventWindow eventWindow = new EventWindow();
        root.setTop(eventWindow.returnTitleGridPane());
        root.setCenter(eventWindow.returnEventGridPane());

        //sets up the stage with the scene (content of window)
        Scene scene = new Scene(root, 1600, 900);
        primaryStage.setScene(scene);

        // Show the Stage (window)
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
