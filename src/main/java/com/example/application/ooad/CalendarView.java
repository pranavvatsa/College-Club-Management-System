package com.example.application.ooad;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("calendar")
public class CalendarView extends VerticalLayout {

    @Autowired
    private EventRepository eventRepository;

    public CalendarView(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

}
