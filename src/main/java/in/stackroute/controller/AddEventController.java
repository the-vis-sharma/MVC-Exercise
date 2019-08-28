package in.stackroute.controller;

import in.stackroute.model.EventType;
import in.stackroute.services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "events/add")
public class AddEventController {

    @RequestMapping(method = RequestMethod.POST)

    public ModelAndView addEvent(@RequestParam("name") String name, @RequestParam("city") String city,
                                 @RequestParam("type") EventType type, @RequestParam("price") double price) {
        ModelAndView model = new ModelAndView();
        EventService service = new EventService();
        service.addEvent(name, city, type, price);
        model.addObject("status", "OK");
        model.addObject("msg", "Event Added.");
        model.setViewName("redirect:all");
        return model;
    }
}
