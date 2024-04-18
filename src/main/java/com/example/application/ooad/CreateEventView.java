package com.example.application.ooad;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Route("create-new-event")
public class CreateEventView extends VerticalLayout {

    @Autowired
    private EventRepository eventRepository;

    public CreateEventView(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        addCreateEventForm();
    }

    private void addCreateEventForm() {
        TextField nameField = new TextField("Event Name");
        TextField clubInChargeField = new TextField("Club In Charge");
        DatePicker dateField = new DatePicker("Date");
        TextField registrationFeesField = new TextField("Registration Fees");

        Button saveButton = new Button("Save");
        saveButton.addClickListener(event -> {
            String name = nameField.getValue();
            String clubInCharge = clubInChargeField.getValue();
            LocalDate localDate = dateField.getValue();
            String date = dateField.getValue().toString();

            double registrationFees = Double.parseDouble(registrationFeesField.getValue());

            Event eventObject = new Event(name, clubInCharge, date, registrationFees);
            eventRepository.save(eventObject);

            Notification.show("Event saved successfully!");
        });

        FormLayout formLayout = new FormLayout();
        formLayout.add(nameField, clubInChargeField, dateField, registrationFeesField, saveButton);

        add(formLayout);
    }
}
