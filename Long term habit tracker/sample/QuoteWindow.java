package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.control.*;


public class QuoteWindow {

    private StackPane quotePane;
    private String quote;

    public QuoteWindow()
    {
        quote = "example of a quote, just for testing purposes";
        quote = "\"" + quote + "\"";
        Label quoteLabel = new Label(quote);
        quotePane = new StackPane(quoteLabel);
        quotePane.setMinSize(50, 15);
    }

    public StackPane GetPane()
    {
        return quotePane;
    }

}
