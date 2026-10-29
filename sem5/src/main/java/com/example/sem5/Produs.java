package com.example.sem5;

import java.io.Serializable;

public class Produs implements Serializable {
    private String denumire;
    private double pret;

    public Produs(String denumire, double pret) {
        this.denumire = denumire;
        this.pret = pret;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return denumire + " - " + pret + " RON";
    }
}