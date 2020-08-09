package org.launchcode.truetastings.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value="events")
//holds methods to handle http requests
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }


//    //handles requests of the form /events/launchcode
//    @GetMapping("{event}")
//    @ResponseBody
//    public String eventWithPathParam(@PathVariable String event){
//        return "hello, " + event;
//    }

    // /events/create
    @GetMapping("create")
    public String createEventForm(){
        return "events/createEventForm";
    }

    //handles form submission
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName){
        events.add(eventName);
        return "redirect:"; //instructs browser to go to a different page
    }


}
