package sample;

import java.util.*;
import java.time.*;

public class Event {

    private ZonedDateTime eventStart, eventEnd;
    private String eventTitle, eventSubtext;
    private int eventType;

    public Event () {
        ZonedDateTime currentDateTime = returnCurrentDateTime();
        eventStart = ZonedDateTime.of(currentDateTime.getYear(), currentDateTime.getMonthValue(), currentDateTime.getDayOfMonth(), 16, 0, 0, 0, returnCurrentZoneId());
        eventEnd = ZonedDateTime.of(currentDateTime.getYear(), currentDateTime.getMonthValue(), currentDateTime.getDayOfMonth(), 17, 0, 0, 0, returnCurrentZoneId());
        eventTitle = "Generic Title";
        eventSubtext = "Generic Subtext";
        eventType = 0;
    }

    public Event (ZonedDateTime eventStart, ZonedDateTime eventEnd, String eventTitle, String eventSubtext, int eventType) {
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.eventTitle = eventTitle;
        this.eventSubtext = eventSubtext;
        this.eventType = eventType;
    }

    public void changeEventStart (ZonedDateTime eventStart) {
        this.eventStart = eventStart;
    }

    public void changeEventEnd (ZonedDateTime eventEnd) {
        this.eventEnd = eventEnd;
    }

    public void changeEventTitle (String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void changeEventSubtext (String eventSubtext) {
        this.eventSubtext = eventSubtext;
    }

    public void changeEventType (int eventType) {
        this.eventType = eventType;
    }

    public ZonedDateTime returnEventStart () {
        return eventStart;
    }

    public ZonedDateTime returnEventEnd () {
        return eventEnd;
    }

    public String returnEventTitle () {
        return eventTitle;
    }

    public String returnEventSubtext () {
        return eventSubtext;
    }

    public int returnEventType () {
        return eventType;
    }

    private ZoneId returnCurrentZoneId () {
        return ZoneId.of( "Europe/Paris" );
    }

    private ZonedDateTime returnCurrentDateTime () {
        return ZonedDateTime.now();
    }

    private void Debug (String toOut) {
        System.out.println(toOut);
    }

    public void PrintAllInfos () {
        String stringDateStart = returnEventStart().getHour() + ":" + returnEventStart().getMinute();
        String stringDateEnd = returnEventEnd().getHour() + ":" + returnEventEnd().getMinute();
        String stringTitle = returnEventTitle();
        String stringSubtext = returnEventSubtext();
        String stringType = "" + returnEventType();
        Debug(stringDateStart);
        Debug(stringDateEnd);
        Debug(stringTitle);
        Debug(stringSubtext);
        Debug(stringType);
    }
}
