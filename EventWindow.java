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

public class EventWindow {

    private ArrayList<Event> eventList;

    public EventWindow (int nb) {
        eventList = new ArrayList<Event>();
        LoadEvents();
        eventList.get(nb).PrintAllInfos();
    }

    private void LoadEvents() {
        System.out.print("Begin loading event dataset...");
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
