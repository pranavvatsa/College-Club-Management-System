package com.example.application.ooad;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route("dashboard")
public class DashboardView extends VerticalLayout {

    @Autowired
    private ClubRepository clubRepository;

    public DashboardView(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
        addHeading();
        displayClubs();
        addButtons();
        addBackToHomePageButton();

    }
    private void addHeading() {
        H2 heading = new H2("Dashboard");
        add(heading);
    }

    private void displayClubs() {
        List<Club> clubs = clubRepository.findAll();
        Grid<Club> grid = new Grid<>(Club.class);
        grid.setItems(clubs);
        grid.setColumns("id", "name");
        add(grid);
    }

    private void addButtons() {
        // Button to browse events
        Button browseEventsButton = new Button("Browse Events");
        browseEventsButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("browse-events")));

        // Button to create new club
        Button createNewClubButton = new Button("Create New Club");
        createNewClubButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("create-new-club")));

        add(browseEventsButton, createNewClubButton);
    }
    private void addBackToHomePageButton() {
        Button backToHomePageButton = new Button("Back to Homepage");
        backToHomePageButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("")));
        add(backToHomePageButton);
    }

}




