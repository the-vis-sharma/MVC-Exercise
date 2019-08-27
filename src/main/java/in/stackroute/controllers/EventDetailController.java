package in.stackroute.controllers;

import in.stackroute.classes.Event;
import in.stackroute.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/events/detail")
public class EventDetailController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEventDetail(@RequestParam("name") String name) {
        ModelAndView model = new ModelAndView();
        EventService service = new EventService();
        Event event = service.getEventByName(name);
        model.addObject("event", event);
        model.setViewName("event-detail");
        return model;
    }
}
