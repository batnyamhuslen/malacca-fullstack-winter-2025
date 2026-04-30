package com.example.config;

public class ShopConfig {

    private final String shopName;
    private final String currency;
    private final double taxRate;
    private final boolean notificationEnabled;

    public ShopConfig(String shopName, String currency,
                      double taxRate, boolean notificationEnabled) {
        this.shopName             = shopName;
        this.currency             = currency;
        this.taxRate              = taxRate;
        this.notificationEnabled  = notificationEnabled;
    }

    public void printConfig() {
        System.out.println("=== Shop Config ===");
        System.out.println("Name:     " + shopName);
        System.out.println("Currency: " + currency);
        System.out.println("Tax:      " + taxRate);
        System.out.println("Notify:   " + notificationEnabled);
    }

    public double getTaxRate() { return taxRate; }
}
