package org.launchcode.truetastings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="events")
public class TastingNotesController {

    // /events/create
    @GetMapping("tasting-notes")
    public String createEventForm(){
        return "events/tastingForm";
    }

    //handles form submission
    @PostMapping("tasting-notes")
    public String createEvent(@RequestParam String eventName){
        return "redirect:"; //instructs browser to go to a different page
    }

}
