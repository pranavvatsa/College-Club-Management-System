package com.example.application.ooad;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Register")
@Route("register")
public class RegisterView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;

    public RegisterView() {
        // Create form components
        TextField usernameField = new TextField("Username");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField confirmPasswordField = new PasswordField("Confirm Password");
        Button registerButton = new Button("Register");
        Button loginButton = new Button("Login");

        // Action when register button is clicked
        registerButton.addClickListener(event -> {
            String username = usernameField.getValue();
            String password = passwordField.getValue();
            String confirmPassword = confirmPasswordField.getValue();

            if (password.equals(confirmPassword)) {
                // Check if username already exists
                User existingUser = userRepository.findByUsername(username);
                if (existingUser != null) {
                    Notification.show("Username already exists. Please choose a different username.");
                } else {
                    // Create new user object and save to database
                    User newUser = new User(username, password);
                    userRepository.save(newUser);
                    Notification.show("Registration successful!");
                    // Redirect to login page
                    getUI().ifPresent(ui -> ui.navigate("login"));
                }
            } else {
                Notification.show("Passwords do not match. Please try again.");
            }
        });

        // Action when login button is clicked
        loginButton.addClickListener(event -> {
            // Redirect to login page
            getUI().ifPresent(ui -> ui.navigate("login"));
        });

        // Add components to the layout
        add(new H1("Register"), usernameField, passwordField, confirmPasswordField, registerButton, loginButton);
    }
}




