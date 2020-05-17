package money.master.views.learn;

import com.vaadin.flow.component.Text;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import money.master.views.main.MainView;

@Route(value = "profile-learn", layout = MainView.class)
public class LearnView extends VerticalLayout{
    public LearnView() {
        add(new Text("It's hard to manage all your finances. What if everything was in one place?"));
        Details loans = new Details("Managing Loans",
                new Text("Toggle using mouse, Enter and Space keys.")); // add html here
        loans.addOpenedChangeListener(e ->
                Notification.show(e.isOpened() ? "Opened" : "Closed"));
        Details credit = new Details("Managing Credit",
                new Text("Toggle using mouse, Enter and Space keys.")
        );
        credit.addOpenedChangeListener(e ->
                Notification.show(e.isOpened() ? "Opened" : "Closed"));
        Details bank = new Details("Banks",
                new Text("Toggle using mouse, Enter and Space keys."));
        bank.addOpenedChangeListener(e ->
                Notification.show(e.isOpened() ? "Opened" : "Closed"));
        Details sideCash = new Details("Making side cash",
                new Text("Toggle using mouse, Enter and Space keys."));
        sideCash.addOpenedChangeListener(e ->
                Notification.show(e.isOpened() ? "Opened" : "Closed"));

    }



}
