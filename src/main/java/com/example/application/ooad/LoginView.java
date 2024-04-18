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

@PageTitle("Login")
@Route("login")
public class LoginView extends VerticalLayout {

    @Autowired
    private UserRepository userRepository;

    public LoginView() {
        TextField usernameField = new TextField("Username");
        PasswordField passwordField = new PasswordField("Password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener(event -> {
            String username = usernameField.getValue();
            String password = passwordField.getValue();

            User user = userRepository.findByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                // Redirect to dashboard view
                getUI().ifPresent(ui -> ui.navigate("dashboard"));
            } else {
                // Show notification for failed login
                Notification.show("Invalid username or password. Please try again.");
            }
        });

        add(new H1("Login"), usernameField, passwordField, loginButton);
    }
}


