package com.example.application.ooad;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.component.html.Paragraph;

@PageTitle("Home")
@Route(value = "")
public class HomePage extends AppLayout {

    public HomePage() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("PES Club Management System");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Paragraph description = new Paragraph(
                "Welcome to PES Club Management System. Manage your clubs and events efficiently with our platform.");
        description.getStyle().set("padding", "2em");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(description);
        setContent(horizontalLayout);

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);

        setPrimarySection(Section.DRAWER);
    }

    private SideNav getSideNav() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Login", "/login",
                        VaadinIcon.CHEVRON_RIGHT.create()),
                new SideNavItem("Signup", "/register",
                        VaadinIcon.CHEVRON_RIGHT.create()),
                new SideNavItem("Dashboard", "/dashboard",
                        VaadinIcon.DASHBOARD.create()),
                new SideNavItem("Browse Events", "/browse-events",
                        VaadinIcon.CALENDAR.create()));
        return nav;
    }
}
