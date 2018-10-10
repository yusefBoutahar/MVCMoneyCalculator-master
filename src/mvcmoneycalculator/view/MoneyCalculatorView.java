package mvcmoneycalculator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MoneyCalculatorView extends JFrame {
    private final JTextField amount = new JTextField(10);
    private final JComboBox comboFrom = new JComboBox();
    private final JComboBox comboTo = new JComboBox();
    JButton exchangeButton = new JButton("Cambio");
    JTextField exchange = new JTextField(10);    

    public MoneyCalculatorView() {
        this.setTitle("MoneyCalculator");
        JPanel mcPanel = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(600, 200);
        
        mcPanel.add(amount);
        mcPanel.add(comboFrom);
        rellenaComboFrom();
        comboFrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                rellenaComboTo((String) comboFrom.getSelectedItem());
            }
        });
        
        rellenaComboTo((String) comboFrom.getSelectedItem());
        mcPanel.add(comboTo);
        mcPanel.add(exchangeButton);
        mcPanel.add(exchange);
        exchange.setEditable(false);
        
        this.add(mcPanel);
        pack();
    }

    public double getAmount() {
        return Double.parseDouble(amount.getText());
    }
    
    public String getFrom() {
        return comboFrom.getSelectedItem().toString();
    }
    
    public String getTo() {
        return comboTo.getSelectedItem().toString();
    }
    
    public void setExchange(double r) {
        exchange.setText(Double.toString(r));
    }
    
    public void addRateListener(ActionListener listenForRateButton) {
        exchangeButton.addActionListener(listenForRateButton);
    }
    
    public void DisplayErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    private void rellenaComboFrom() {
        comboFrom.addItem("USD");
        comboFrom.addItem("EUR");
        comboFrom.addItem("GBP");
    }
    
    private void rellenaComboTo(String selectedItem) {
        comboTo.removeAllItems();
        if (selectedItem.equals("USD")) {
            comboTo.addItem("EUR");
            comboTo.addItem("GBP");
        } else if (selectedItem.equals("EUR")) {
            comboTo.addItem("USD");
            comboTo.addItem("GBP");
        } else if (selectedItem.equals("GBP")) {
            comboTo.addItem("USD");
            comboTo.addItem("EUR");
        }
    }    
}
