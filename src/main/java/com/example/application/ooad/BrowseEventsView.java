package com.example.application.ooad;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("browse-events")
public class BrowseEventsView extends VerticalLayout {

    @Autowired
    private EventRepository eventRepository;

    public BrowseEventsView(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        addHeading();
        displayEvents();
        addCreateNewEventButton();
        addBackToHomePageButton();
    }

    private void addHeading() {
        H2 heading = new H2("Browse Events");
        add(heading);
    }

    private void displayEvents() {
        List<Event> events = eventRepository.findAll();
        Grid<Event> grid = new Grid<>(Event.class);
        grid.setItems(events);
        grid.setColumns("name", "clubInCharge", "date", "registrationFees");
        add(grid);
    }

    private void addCreateNewEventButton() {
        Button createNewEventButton = new Button("Create New Event");
        createNewEventButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("create-new-event")));
        add(createNewEventButton);
    }

    private void addBackToHomePageButton() {
        Button backToHomePageButton = new Button("Back to Homepage");
        backToHomePageButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("")));
        add(backToHomePageButton);
    }
}
