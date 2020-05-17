package money.master.views.main;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = HomeView.class)
public class Home extends VerticalLayout {
    private final Image main = new Image("image/mainPage.png", "Money");
    public Home() {
    
        H1 header = new H1("Welcome to MoneyMaster, your Money Managing Machine!");
        add(header);
        setHorizontalComponentAlignment(Alignment.CENTER, header);
        
        main.setWidth("80em");
        add(main);
    }
}
