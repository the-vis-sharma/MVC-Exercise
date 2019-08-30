package in.stackroute.controller;

import in.stackroute.model.Event;
import in.stackroute.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/events/detail")
public class EventDetailController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEventDetail(@RequestParam("id") int id) {
        ModelAndView model = new ModelAndView();
        Event event = eventService.getEventById(id);
        model.addObject("event", event);
        model.setViewName("event-detail");
        return model;
    }
}
