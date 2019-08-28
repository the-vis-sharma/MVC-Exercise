package in.stackroute.services;

import in.stackroute.model.Event;
import in.stackroute.model.EventType;

import java.util.ArrayList;
import java.util.List;

public class EventService {

    private static List<Event> allEvents = new ArrayList<>();

    public void addEvent(Event event) {
        allEvents.add(event);
    }

    public List<EventType> getEventTypes() {
        List<EventType> types = new ArrayList<>();
        types.add(EventType.Cricket);
        types.add(EventType.Football);
        types.add(EventType.Badminton);
        return types;
    }

    public Event getEventByName(String name) {
        for( Event event : allEvents) {
            if(event.getName().contains(name)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public void setAllEvents(List<Event> allEvents) {
        this.allEvents = allEvents;
    }
}
