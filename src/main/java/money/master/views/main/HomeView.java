package money.master.views.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import money.master.views.features.Features;

public class HomeView extends AppLayout {
    private final Image logo = new Image("image/Logo.png", "Logo");
    private final MenuBar profile = new MenuBar();
    
    public HomeView() {
        logo.setWidth("5em");
        HorizontalLayout menu = new HorizontalLayout();
        menu.setPadding(true);
        
        logo.addClickListener(onClick -> UI.getCurrent().navigate(Home.class));
        
        menu.add(logo);
        
        Tabs tab = new Tabs();
        tab.add(createTab(VaadinIcon.BOOK_DOLLAR, "Features", Features.class));
        
        Button signIn = new Button("Sign In");
        
        signIn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        
//        HorizontalLayout profileLayout = new HorizontalLayout();
//        profileLayout.setPadding(false);
//        profileLayout.setMargin(false);
//        profileLayout.add(new Icon(VaadinIcon.USER));
//        profileLayout.add("Profile");
//
//        profile.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
//
//        MenuItem profileItem = profile.addItem(profileLayout);
//        SubMenu profileSubMenu = profileItem.getSubMenu();
//        profileSubMenu.addItem("Update Profile", onClick -> UI.getCurrent().navigate(Profile.class));
//        profileSubMenu.add(new Hr());
//        profileSubMenu.addItem("Sign Out");
        
        menu.add(tab);
        menu.add(signIn);
        
        menu.setWidthFull();
        
        menu.setAlignItems(FlexComponent.Alignment.CENTER);
        menu.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        
        addToNavbar(menu);
    }
    
    /**
     * Creates a Tab with the given parameters
     * <p>
     * Uses {@link #createTab(Component)} to finish up the process
     *
     * @param icon      The Icon for the Tab
     * @param title     The Title of the Tab
     * @param viewClass The Class that the tab should redirect to
     * @return The Tab with all of the constraints
     */
    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        RouterLink routerLink = new RouterLink(null, viewClass);
        routerLink.setHighlightCondition(HighlightConditions.sameLocation());
        return createTab(populateLink(routerLink, icon, title));
    }
    
    /**
     * Creates a Tab with the given Components
     *
     * @param content The content inside the tab
     * @return The final Tab
     */
    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }
    
    /**
     * Format the "T" (Usually {@link RouterLink}) to have the icon and title inside
     *
     * @param a     the RouterLink or Component that should have the constraints
     * @param icon  The Icon
     * @param title The Title
     * @param <T>   Usually a RouterLink, something allowing tab redirection
     * @return The "T" with the icon and title connected
     */
    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }
    
}
