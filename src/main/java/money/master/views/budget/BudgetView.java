package money.master.views.budget;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.NumberRenderer;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import money.master.backend.Salary;
import money.master.backend.Spending;
import money.master.views.main.MainView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Route(value = "profile/budget", layout = MainView.class)
@UIScope
@PreserveOnRefresh
public class BudgetView extends VerticalLayout {
    
    private Salary salary = new Salary(BigDecimal.ZERO);
    private BigDecimal toSave = null;
    
    private Button addSpendingButton = createSpendingButton();
    private Button fixedButton = createFixedButton();
    
    private Grid<Spending> spendingGrid;
    
    public static final List<Spending> spendingList = new ArrayList<>();
    public static final List<Spending> fixedList = new ArrayList<>();
    
    public static H3 fixedSpendingIncomeValue = new H3(Spending.getSum(fixedList).toString());
    
    public BudgetView() {

        if (salary.equals(BigDecimal.ZERO) || toSave == null) {
            Notification main = new Notification();
            BigDecimalField salaryField = new BigDecimalField("Yearly Salary");
            BigDecimalField toSaveField = new BigDecimalField("Amount to Save");
    
            salaryField.addValueChangeListener(onChange -> {
                salary = new Salary(onChange.getValue());
                toSaveField.setValue(onChange.getValue().multiply(new BigDecimal("0.05")));
            });
    
            toSaveField.addValueChangeListener(onChange -> {
                toSave = onChange.getValue();
            });
    
            main.add(salaryField, toSaveField);
    
            Button save = new Button("Save", onChange -> {
                salary = new Salary(salaryField.getValue());
                toSave = toSaveField.getValue();
                main.close();
    
                resetStage();
            });
    
            main.add(save);
    
            main.setPosition(Notification.Position.MIDDLE);
    
            main.open();
        }
        else {
            resetStage();
        }
    }
        
        
    public Button createFixedButton() {
        Button fButton = new Button("Add Fixed Spending/Income");

        fButton.addClickListener(onClick -> {
            Notification addHours = new Notification();

            TextField name = new TextField("What did you get/purchase");
            name.setPlaceholder("Groceries");

            BigDecimalField currencyInput = new BigDecimalField("How much is it worth? ($)");
            currencyInput.setPlaceholder("22.99");
            
            RadioButtonGroup<String> gainLoseSelect = new RadioButtonGroup<>();
            gainLoseSelect.setLabel("Gain/Lose");
            gainLoseSelect.setItems("Gain", "Lose");
            gainLoseSelect.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
            
            RadioButtonGroup<String> essentialSelect = new RadioButtonGroup<>();
            essentialSelect.setLabel("Essential or Non-Essential");
            essentialSelect.setItems("Essential", "Non-Essential");
            essentialSelect.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);

            HorizontalLayout notificationLayout = new HorizontalLayout(name, currencyInput, gainLoseSelect, essentialSelect);

            Button saveButton = new Button("Save", onSave -> {
                Spending spending = new Spending();
                fixedList.add(spending);
                spending.setName(name.getValue());
                spending.setAmt(currencyInput.getValue());
                spending.setEssential(essentialSelect.getValue().equals("Essential"));
                spending.setChange(gainLoseSelect.getValue().equals("Gain"));

                name.setValue("");
                currencyInput.setValue(BigDecimal.ZERO);
                essentialSelect.setValue("");
                gainLoseSelect.setValue("");
                
                resetFixedSpendingIncomeValue();
            });
            saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

            Button closeButton = new Button("Close", onCloseClick -> {
                addHours.close();
                resetFixedSpendingIncomeValue();
    
                resetStage();
            });
    
            resetFixedSpendingIncomeValue();
            
            addHours.setPosition(Notification.Position.MIDDLE);
            notificationLayout.setWidthFull();

            addHours.add(notificationLayout);
            HorizontalLayout buttonBar = new HorizontalLayout(saveButton, closeButton);
            buttonBar.setAlignSelf(CENTER);
            buttonBar.setJustifyContentMode(JustifyContentMode.CENTER);
            addHours.add(buttonBar);
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

            BigDecimalField currencyInput = new BigDecimalField("How much is it worth? ($)");
            currencyInput.setPlaceholder("22.99");
    
            RadioButtonGroup<String> gainLoseSelect = new RadioButtonGroup<>();
            gainLoseSelect.setLabel("Gain/Lose");
            gainLoseSelect.setItems("Gain", "Lose");
            gainLoseSelect.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
    
            RadioButtonGroup<String> essentialSelect = new RadioButtonGroup<>();
            essentialSelect.setLabel("Essential or Non-Essential");
            essentialSelect.setItems("Essential", "Non-Essential");
            essentialSelect.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
    
            DatePicker dateChooser = new DatePicker("Select Date");
            dateChooser.setMax(LocalDate.now());
            dateChooser.setValue(LocalDate.now());

            HorizontalLayout notificationLayout = new HorizontalLayout(name, currencyInput, gainLoseSelect, essentialSelect, dateChooser);

            Button saveButton = new Button("Save", onSave -> {
                Spending spending = new Spending();
                spending.setName(name.getValue());
                spending.setAmt(currencyInput.getValue());
                spending.setEssential(essentialSelect.getValue().equals("Essential"));
                spending.setChange(gainLoseSelect.getValue().equals("Gain"));
                spending.setLocalDate(dateChooser.getValue());
                spendingList.add(spending);
                name.setValue("");
                currencyInput.setValue(BigDecimal.ZERO);
                essentialSelect.setValue("");
                gainLoseSelect.setValue("");
                dateChooser.setValue(LocalDate.now());
                spendingGrid.setItems(spendingList);
            });

            Button closeButton = new Button("Close", onCloseClick -> {
                spendingGrid.setItems(spendingList);
                addHours.close();
            });
            saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
            closeButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
            
            addHours.setPosition(Notification.Position.MIDDLE);
            notificationLayout.setWidthFull();

            addHours.add(notificationLayout);
            HorizontalLayout buttonBar = new HorizontalLayout(saveButton, closeButton);
            buttonBar.setAlignSelf(CENTER);
            buttonBar.setJustifyContentMode(JustifyContentMode.CENTER);
            addHours.add(buttonBar);
            addHours.open();
        });

        return button;
    }
    
    public void resetStage() {
        removeAll();
        add(new H1("Auto-Budgeter!"));
    
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(CENTER);
    
    
        add(new H3(String.format("Salary: %s/year", salary.toString())));
        add(new H3(String.format("Savings: $%s/year", toSave.toString())));
    
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
    
        spendingGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_ROW_STRIPES);
    
    
        add(new H2("Fixed Costs/Income"));
        add(fixedSpendingIncomeValue);
        add(fixedButton);
        add(new H2("Spending"));
        add(addSpendingButton);
        add(spendingGrid);
    }
    
    public void resetFixedSpendingIncomeValue() {
        fixedSpendingIncomeValue = new H3(Spending.getSum(fixedList).toString());
    }

}
