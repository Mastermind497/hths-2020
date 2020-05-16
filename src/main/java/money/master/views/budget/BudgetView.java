package money.master.views.budget;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.NumberRenderer;
import com.vaadin.flow.router.Route;
import money.master.backend.Salary;
import money.master.backend.Spending;
import money.master.views.main.MainView;

import java.math.BigDecimal;
import java.util.*;

@Route(value = "profile/budget", layout = MainView.class)
public class BudgetView extends VerticalLayout {
    
    private Salary salary = new Salary(BigDecimal.valueOf(150000));

    private Button addSpendingButton = createSpendingButton();
    private Button fixedButton = createFixedButton();
    
    private Grid<Spending> spendingGrid;

    public static final List<Spending> spendingList = new ArrayList<>();
    public static final List<Spending> fixedList = new ArrayList<>();
    
    public BudgetView() {
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        
        add(new H1("Auto-Budgeter!"));
        add(addSpendingButton);
        add(fixedButton);
        
        add(new H3("Spending"));
        spendingGrid = new Grid<>();
        spendingGrid.addColumn(Spending::getName, "Name", "String")
                .setHeader("Name of Purchase/Gain")
                .setAutoWidth(true)
                .setSortable(true);
        spendingGrid.addColumn(new NumberRenderer<>(
                    Spending::getAmt, "$ %(,.2f", Locale.US, "$ 0.00"),
                               "BigDecimal", "Value")
                .setHeader("Value")
                .setAutoWidth(true)
                .setSortable(true);
        spendingGrid.addColumn(Spending::getChange, "Change", "String")
                .setHeader("Gain/Loss")
                .setAutoWidth(true)
                .setSortable(true);
        spendingGrid.addColumn(Spending::getEssential, "Name", "String")
                .setHeader("Essentiality")
                .setAutoWidth(true)
                .setSortable(true);
        spendingGrid.addColumn(Spending::getLocalDate, "Date", "Time")
                .setHeader("Date")
                .setAutoWidth(true)
                .setSortable(true);
        spendingGrid.setWidthFull();
        spendingGrid.setMaxHeight("60%");
        spendingGrid.setHeightByRows(true);
        
        add(spendingGrid);
    }
        
        
    public Button createFixedButton() {
        Button fButton = new Button("Add Fixed Spending/Income");

        fButton.addClickListener(onClick -> {
            Notification addHours = new Notification();

            TextField name = new TextField("What did you get/purchase");
            name.setPlaceholder("Groceries");

            NumberField currencyInput = new NumberField("How much is it worth? ($)");
            currencyInput.setPlaceholder("22.99");

            Select<String> gainLoseSelect = new Select<>();
            gainLoseSelect.setItems("Gain", "Lose");
            gainLoseSelect.setPlaceholder("Gain/Lose");

            Select<String> essentialSelect = new Select<>();
            essentialSelect.setItems("Essential", "Non-essential");
            essentialSelect.setValue("Essential");

            HorizontalLayout notificationLayout = new HorizontalLayout(name, currencyInput, gainLoseSelect, essentialSelect);

            Button saveButton = new Button("Save", onSave -> {
                Spending spending = new Spending();
                spendingList.add(spending);
                spending.setName(name.getValue());
                spending.setAmt(BigDecimal.valueOf(currencyInput.getValue()));
                spending.setEssential(essentialSelect.getValue().equals("Essential"));
                spending.setChange(gainLoseSelect.getValue().equals("Gain"));

                name.setValue("");
                currencyInput.setValue(0d);
                essentialSelect.setValue("");
                gainLoseSelect.setValue("");
            });

            Button closeButton = new Button("Close", onCloseClick -> addHours.close());

            addHours.add(notificationLayout);
            addHours.add(saveButton, closeButton);
            addHours.open();
        });

        return fButton;
    }

    public Button createSpendingButton() {
        Button button = new Button("Add Loss/Gain");

        button.addClickListener(onClick -> {
            Notification addHours = new Notification();

            TextField name = new TextField("What did you get/purchase");
            name.setPlaceholder("Groceries");

            NumberField currencyInput = new NumberField("How much is it worth? ($)");
            currencyInput.setPlaceholder("22.99");
            
            Select<String> gainLoseSelect = new Select<>();
            gainLoseSelect.setItems("Gain", "Lose");
            gainLoseSelect.setPlaceholder("Gain/Lose");

            Select<String> essentialSelect = new Select<>();
            essentialSelect.setItems("Essential", "Non-essential");
            essentialSelect.setValue("Essential");

            HorizontalLayout notificationLayout = new HorizontalLayout(name, currencyInput, gainLoseSelect, essentialSelect);

            Button saveButton = new Button("Save", onSave -> {
                Spending spending = new Spending();
                fixedList.add(spending);
                spending.setName(name.getValue());
                spending.setAmt(BigDecimal.valueOf(currencyInput.getValue()));
                spending.setEssential(essentialSelect.getValue().equals("Essential"));
                spending.setChange(gainLoseSelect.getValue().equals("Gain"));
                name.setValue("");
                currencyInput.setValue(0d);
                essentialSelect.setValue("");
                gainLoseSelect.setValue("");
            });

            Button closeButton = new Button("Close", onCloseClick -> {
                addHours.close();
                spendingGrid.setItems(spendingList);
            });

            addHours.add(notificationLayout);
            addHours.add(saveButton, closeButton);
            addHours.open();
        });

        return button;
    }

}
