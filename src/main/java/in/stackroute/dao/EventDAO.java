package in.stackroute.dao;

import in.stackroute.model.Event;

import java.util.List;

public interface EventDAO {

    boolean insertEvent(Event event);

    List<Event> getAllEvents();

    List<Event> searchEvent(String query);

    Event getEventDetail(int id);

}
