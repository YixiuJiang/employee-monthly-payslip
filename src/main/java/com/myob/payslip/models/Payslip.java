package com.myob.payslip.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payslip {

  private Employee employee;
  private LocalDate paymentStartDate;
  private LocalDate paymentEndDate;
  private BigDecimal grossIncome;
  private BigDecimal incomeTax;
  private BigDecimal superannuation;
  private BigDecimal netIncome;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public LocalDate getPaymentStartDate() {
    return paymentStartDate;
  }

  public void setPaymentStartDate(LocalDate paymentStartDate) {
    this.paymentStartDate = paymentStartDate;
  }

  public LocalDate getPaymentEndDate() {
    return paymentEndDate;
  }

  public void setPaymentEndDate(LocalDate paymentEndDate) {
    this.paymentEndDate = paymentEndDate;
  }

  public BigDecimal getGrossIncome() {
    return grossIncome;
  }

  public void setGrossIncome(BigDecimal grossIncome) {
    this.grossIncome = grossIncome;
  }

  public BigDecimal getIncomeTax() {
    return incomeTax;
  }

  public void setIncomeTax(BigDecimal incomeTax) {
    this.incomeTax = incomeTax;
  }

  public BigDecimal getSuperannuation() {
    return superannuation;
  }

  public void setSuperannuation(BigDecimal superannuation) {
    this.superannuation = superannuation;
  }

  public BigDecimal getNetIncome() {
    return netIncome;
  }

  public void setNetIncome(BigDecimal netIncome) {
    this.netIncome = netIncome;
  }
}
