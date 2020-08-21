package org.launchcode.truetastings.controllers;

import org.hibernate.event.spi.EventType;
import org.launchcode.truetastings.data.EventRepository;
import org.launchcode.truetastings.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping
//holds methods to handle http requests
public class EventController {

    @Autowired
    private EventRepository eventRepository;



    @GetMapping
    public String displayEvents(Model model){
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }


    @GetMapping("create-event")
    public String createEventForm(Model model){
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());

        return "events/createEventForm";
    }

    //handles form submission
    @PostMapping("create-event")
    public String createEvent(@ModelAttribute Event newEvent){
        eventRepository.save(newEvent);
        return "redirect:/"; //instructs browser to go to a different page
    }

    @GetMapping("delete-event")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/deleteEvent";
    }


    @PostMapping("delete-event")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:/"; //instructs browser to go to a different page
    }

}
