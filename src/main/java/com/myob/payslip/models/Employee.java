package com.myob.payslip.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

  private String firstName;
  private String lastName;
  private BigDecimal aunualSalary;
  private BigDecimal superRate;
  private LocalDate paymentStartDate;
  private LocalDate paymentEndDate;
  private String paymentPeriod;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public BigDecimal getAunualSalary() {
    return aunualSalary;
  }

  public void setAunualSalary(BigDecimal aunualSalary) {
    this.aunualSalary = aunualSalary;
  }

  public BigDecimal getSuperRate() {
    return superRate;
  }

  public void setSuperRate(BigDecimal superRate) {
    this.superRate = superRate;
  }

  public LocalDate getPaymentEndDate() {
    return paymentEndDate;
  }

  public void setPaymentEndDate(LocalDate paymentEndDate) {
    this.paymentEndDate = paymentEndDate;
  }

  public LocalDate getPaymentStartDate() {

    return paymentStartDate;
  }

  public void setPaymentStartDate(LocalDate paymentStartDate) {
    this.paymentStartDate = paymentStartDate;
  }

  public String getName(){
    return this.firstName + " "+this.lastName;
  }

  public String getPaymentPeriod() {
    return paymentPeriod;
  }

  public void setPaymentPeriod(String paymentPeriod) {
    this.paymentPeriod = paymentPeriod;
  }
}
