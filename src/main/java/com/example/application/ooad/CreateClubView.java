package com.example.application.ooad;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("create-new-club")
public class CreateClubView extends VerticalLayout {

    @Autowired
    private ClubRepository clubRepository;

    public CreateClubView(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
        createClubForm();
    }

    private void createClubForm() {
        TextField nameField = new TextField("Name");
        Button saveButton = new Button("Save");
        saveButton.addClickListener(event -> {
            String name = nameField.getValue();
            Club club = new Club();
            club.setName(name);
            clubRepository.save(club);
            Notification.show("Club saved successfully!");
        });

        add(nameField, saveButton);
    }
}

