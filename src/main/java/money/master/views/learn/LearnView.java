package money.master.views.learn;

import com.vaadin.flow.component.Text;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import money.master.views.main.HomeView;

@Route(value = "features", layout = HomeView.class)
public class LearnView extends VerticalLayout{
    public LearnView() {
        add(new Text("something"));


    }



}
