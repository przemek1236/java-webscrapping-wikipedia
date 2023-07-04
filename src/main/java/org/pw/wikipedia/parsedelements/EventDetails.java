package org.pw.wikipedia.parsedelements;

import org.pw.core.ParsedElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDetails extends ParsedElement {

    private final String eventName;
    private final String description;
    private final Date eventDate;
    private final String venue;
    private final String location;
    private final String attendance;


    public EventDetails(String eventName,
                        String description,
                        String eventDate,
                        String venue,
                        String location,
                        String attendance) {
        this.eventName = eventName;
        this.description = description;
        this.venue = venue;
        this.location = location;
        this.attendance = attendance;
        this.eventDate = parseDate(eventDate);
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getVenue() {
        return venue;
    }

    public String getLocation() {
        return location;
    }

    public String getAttendance() {
        return attendance;
    }

    private Date parseDate(String date) {
        String[] splitDate = date.split(" ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-M-d");
        try {
            return simpleDateFormat.parse(splitDate[splitDate.length - 1].substring(1, 11));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Date (%s) could not conform format".formatted(date));
        }
    }

    @Override
    public String toString() {
        return "|%s \t %s \t %s \t %s \t %s \t %s |".formatted(
                eventName,
                description,
                eventDate,
                venue,
                location,
                attendance
        );
    }
}
