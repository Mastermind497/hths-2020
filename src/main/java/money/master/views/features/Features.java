package money.master.views.features;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import money.master.views.main.Home;

@Route(value = "Features", layout = Home.class)
public class Features extends VerticalLayout {
    public Features() {
        add(new H1("App Features"));
        add(new Text("Text"));
    }
}
