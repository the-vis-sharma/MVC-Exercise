package in.stackroute.services;

import in.stackroute.dao.EventDAOImp;
import in.stackroute.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventDAOImp eventDAOImp;

    public void addEvent(Event event) {
        eventDAOImp.insertEvent(event);
    }

    public List<String> getEventTypes() {
        List<String> types = new ArrayList<>();
        types.add("Cricket");
        types.add("Football");
        types.add("Badminton");
        return types;
    }

    public Event getEventById(int id) {
        return eventDAOImp.getEventDetail(id);
    }

    public List<Event> searchEvent(String query) {
        return eventDAOImp.searchEvent(query);
    }

    public List<Event> getAllEvents() {
        return eventDAOImp.getAllEvents();
    }

}
