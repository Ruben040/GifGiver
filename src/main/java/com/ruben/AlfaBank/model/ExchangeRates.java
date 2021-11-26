package com.ruben.AlfaBank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.TreeMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRates {

    private TreeMap<String, Double> rates;

    public TreeMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(TreeMap<String, Double> rates) {
        this.rates = rates;
    }

}
