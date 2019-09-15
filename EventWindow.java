package sample;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import java.time.*;

import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class EventWindow {

    private ArrayList<Event> eventList;
    private GridPane titlePane, eventsPane;

    public EventWindow () {
        LoadEvents();
        GenerateEventsGridPane();
    }

    private void GenerateEventsGridPane () {
        GenerateEventsTitle();
        GenerateEventsEvent();
    }

    private void GenerateEventsTitle () {
        titlePane = new GridPane();
        Label titleLabel = new Label("EVENT");
        titlePane.add(titleLabel, 0, 0);
    }

    private void GenerateEventsEvent () {
        eventsPane = new GridPane();
        for (int i=0; i<eventList.size(); i++) {
            Event event = eventList.get(i);
            Label eventTitleLabel = new Label(event.returnEventTitle() + " ");
            Label eventSubtextLabel = new Label(event.returnEventSubtext() + " ");
            Label eventDateLabel = new Label(event.returnStringEventStart() + "-" + event.returnStringEventEnd());
            eventsPane.add(eventTitleLabel, 0, i + 1);
            eventsPane.add(eventSubtextLabel, 1, i + 1);
            eventsPane.add(eventDateLabel, 2, i + 1);
        }
    }

    public GridPane returnTitleGridPane () {
        return titlePane;
    }

    public GridPane returnEventGridPane () {
        return eventsPane;
    }

    private void LoadEvents() {
        System.out.print("Begin loading event dataset...");
        eventList = new ArrayList<Event>();
        String fileName = "data/Event_data.csv";
        Path myPath = Paths.get("src/sample/" + fileName);
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8); CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).build()) {
            reader.readNext();
            // reads the line and assigns them
            int nbOfLine = 0;
            String[] line;
            while ((line = reader.readNext()) != null) {
                Event loadedEvent = createEventFromLoadedLine(line);
                eventList.add(loadedEvent);
                nbOfLine++;
            }
            System.out.println("Success, number of loaded events: " + nbOfLine);

        } catch (IOException e) {
            System.out.println("Failure! Something went wrong");
            e.printStackTrace();
        }
    }

    private Event createEventFromLoadedLine (String[] line) {
        ZonedDateTime loadedEventStart = ZonedDateTime.parse(line[0]);
        ZonedDateTime loadedEventEnd = ZonedDateTime.parse(line[1]);
        String loadedEventTitle = line[2];
        String loadedEventSubtext = line[3];
        int loadedEventType = Integer.parseInt(line[4]);
        Event loadedEvent = new Event(loadedEventStart, loadedEventEnd, loadedEventTitle, loadedEventSubtext, loadedEventType);
        return loadedEvent;
    }
}
