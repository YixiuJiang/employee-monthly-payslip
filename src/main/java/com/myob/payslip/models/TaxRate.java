package com.myob.payslip.models;

public class TaxRate {

  private int taxableIncomeStart;
  private int taxableIncomeEnd;
  private double rate;

  public int getTaxableIncomeStart() {
    return taxableIncomeStart;
  }

  public void setTaxableIncomeStart(int taxableIncomeStart) {
    this.taxableIncomeStart = taxableIncomeStart;
  }

  public int getTaxableIncomeEnd() {
    return taxableIncomeEnd;
  }

  public void setTaxableIncomeEnd(int taxableIncomeEnd) {
    this.taxableIncomeEnd = taxableIncomeEnd;
  }

  public double getRate() {
    return rate;
  }

  public void setRate(double rate) {
    this.rate = rate;
  }

  public boolean matchingRate(int income) {
    return income >= taxableIncomeStart;
  }
}
