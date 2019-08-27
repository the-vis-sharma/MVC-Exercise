package in.stackroute.controllers;

import in.stackroute.classes.EventType;
import in.stackroute.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getEventTypes() {
        ModelAndView model = new ModelAndView();
        EventService service = new EventService();
        List<EventType> types = service.getEventTypes();
        model.addObject("types", types);
        model.setViewName("home");
        return model;
    }
}
