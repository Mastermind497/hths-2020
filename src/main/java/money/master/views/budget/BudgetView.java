package money.master.views.budget;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import money.master.backend.Spending;
import money.master.views.main.MainView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Route(value = "profile/budget", layout = MainView.class)
public class BudgetView extends VerticalLayout {

    private Button addSpendingButton = createSpendingButton();

    public static final List<Spending> spendingList = new ArrayList<>();

    public Button createSpendingButton() {
        Button button = new Button("Add Loss/Gain");

        button.addClickListener(onClick -> {
            Notification addHours = new Notification();

            TextField name = new TextField("What did you get/purchase");
            name.setPlaceholder("Groceries");

            NumberField currencyInput = new NumberField("How much is it worth? ($)");
            currencyInput.setPlaceholder("22.99");

            DatePicker spendingDate = new DatePicker();
            spendingDate.setLabel("Date");
            spendingDate.setValue(LocalDate.now());
            spendingDate.setMax(LocalDate.now());

            Select<String> gainLoseSelect = new Select<>();
            gainLoseSelect.setItems("Gain", "Lose");
            gainLoseSelect.setPlaceholder("Gain/Lose");

            Select<String> essentialSelect = new Select<>();
            essentialSelect.setItems("Essential", "Non-essential");
            essentialSelect.setValue("Essential");

            HorizontalLayout notificationLayout = new HorizontalLayout(name, currencyInput, gainLoseSelect, essentialSelect, spendingDate);

            Button saveButton = new Button("Save", onSave -> {
                Spending spending = new Spending();
                spendingList.add(spending);
                spending.setName(name.getValue());
                spending.setAmt(BigDecimal.valueOf(currencyInput.getValue()));
                spending.setEssential(essentialSelect.getValue().equals("Essential"));
                spending.setChange(gainLoseSelect.getValue().equals("Gain"));
                spending.setLocalDate(spendingDate.getValue());
                name.setValue("");
                currencyInput.setValue(0d);
                essentialSelect.setValue("");
                gainLoseSelect.setValue("");
                spendingDate.setValue(LocalDate.now());
            });

            Button closeButton = new Button("Close", onCloseClick -> addHours.close());

            addHours.add(notificationLayout);
            addHours.add(saveButton, closeButton);
            addHours.open();
        });

        return button;
    }

}
