package mvcmoneycalculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvcmoneycalculator.model.MoneyCalculatorModel;
import mvcmoneycalculator.view.MoneyCalculatorView;

public class MoneyCalculatorController {
    private MoneyCalculatorModel theModel;
    private MoneyCalculatorView theView;

    public MoneyCalculatorController(MoneyCalculatorModel theModel, MoneyCalculatorView theView) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.addRateListener(new RateListener());
    }

    private class RateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            double amount;
            String from;
            String to;
            
            try {
              amount = theView.getAmount();
              from = theView.getFrom();
              to = theView.getTo();
              
              theModel.calculateExchange(amount, from, to);
              theView.setExchange(theModel.getExchange());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.DisplayErrorMessage("Debes introducir un número");
            } catch (IOException ex) {
                Logger.getLogger(MoneyCalculatorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

}
