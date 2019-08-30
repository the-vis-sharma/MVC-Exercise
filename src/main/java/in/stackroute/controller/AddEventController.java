package in.stackroute.controller;

import in.stackroute.model.Event;
import in.stackroute.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "events/add")
public class AddEventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.POST)

    public ModelAndView addEvent(@ModelAttribute("event") Event event) {
        ModelAndView model = new ModelAndView();
        eventService.addEvent(event);
        model.addObject("status", "OK");
        model.addObject("msg", "Event Added.");
        model.setViewName("redirect:all");
        return model;
    }
}
