package in.stackroute.controller;

import in.stackroute.model.Event;
import in.stackroute.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "events/all")
public class EventListController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEventList() {
        ModelAndView model = new ModelAndView();
        List<Event> allEvents = eventService.getAllEvents();
        model.addObject("list", allEvents);
        model.setViewName("list-events");
        return model;
    }

}
