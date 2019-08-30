package in.stackroute.controller;

import in.stackroute.model.Event;
import in.stackroute.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "events/search")
public class SearchController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView searchEvent(@RequestParam("query") String query) {
        ModelAndView  model = new ModelAndView();
        List<Event> eventList = eventService.searchEvent(query);
        model.addObject("list", eventList);
        model.setViewName("list-events");
        return model;
    }
}
