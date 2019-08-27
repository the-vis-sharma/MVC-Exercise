package in.stackroute.controllers;

import in.stackroute.classes.Event;
import in.stackroute.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "events/all")
public class EventListController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEventList() {
        ModelAndView model = new ModelAndView();
        EventService service = new EventService();
        List<Event> allEvents = service.getAllEvents();
        model.addObject("list", allEvents);
        model.setViewName("list-events");
        return model;
    }

}
