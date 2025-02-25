package edu.unisabana.dyas.patterns.observer.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * @author cesarvefe
 
 */
public class ConfigurationManager extends AbstractObservable {

    private SimpleDateFormat defaultDateFormat;
    private NumberFormat moneyFormat;

    private static ConfigurationManager configurationManager;

    private ConfigurationManager() {
        this.defaultDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        this.moneyFormat = new DecimalFormat("##.00");
    }

    public static ConfigurationManager getInstance() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    public SimpleDateFormat getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public void setDefaultDateFormat(SimpleDateFormat defaultDateFormat) {
        System.out.println("Date Format change > " + 
                (this.defaultDateFormat!=null 
                        ?this.defaultDateFormat.toPattern():"Null") + " to " 
                + defaultDateFormat.toPattern());
        this.defaultDateFormat = defaultDateFormat;
        notifyAllObservers("defaultDateFormat", this);
    }

    public NumberFormat getMoneyFormat() {
        return moneyFormat;
    }

    public void setMoneyFormat(NumberFormat moneyFormat) {
        System.out.println("Money Format change > " + 
                (this.moneyFormat != null 
                    ? this.moneyFormat.format(1.11) : "Null") + " to " 
                + moneyFormat.format(1.11));
        this.moneyFormat = moneyFormat;
        notifyAllObservers("moneyFormat", this);
    }    
}