package mvcmoneycalculator.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MoneyCalculatorModel {
    private double amount;
    private String from;
    private String to;
    private double exchange;
    
    public void calculateExchange(double amount, 
            String from, String to) throws IOException {
        double exchangeRate = getExchangeRate(from, to);
        exchange = amount * exchangeRate;
    }

    public double getExchange() {
        return exchange;
    }
    
    private double getExchangeRate(String from, String to) throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, 
                    line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }
}
