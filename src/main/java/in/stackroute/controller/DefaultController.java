package in.stackroute.controller;

import in.stackroute.model.Event;
import in.stackroute.model.EventType;
import in.stackroute.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayForm() {
        ModelAndView model = new ModelAndView();
        Event event = new Event();
        model.addObject("event", event);
        model.setViewName("home");
        return model;
    }

    @ModelAttribute("eventTypes")
    public List<String> getEventTypes() {
        EventService service = new EventService();
        List<String> types = service.getEventTypes();
        return types;
    }
}
