package mvcmoneycalculator;

import mvcmoneycalculator.controller.MoneyCalculatorController;
import mvcmoneycalculator.model.MoneyCalculatorModel;
import mvcmoneycalculator.view.MoneyCalculatorView;

public class MVCMoneyCalculator {

    public static void main(String[] args) {
        MoneyCalculatorModel model = new MoneyCalculatorModel();
        MoneyCalculatorView view = new MoneyCalculatorView();
        MoneyCalculatorController controller = 
                new MoneyCalculatorController(model, view);
        view.setVisible(true);        
    }
    
}
