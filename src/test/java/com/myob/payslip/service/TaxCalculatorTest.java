package com.myob.payslip.service;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxCalculatorTest {

  private BigDecimal annualSalary = new BigDecimal(120000);

  @Autowired
  private TaxCalculator taxCalculator;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void calculateGrossIncome() throws Exception {
    BigDecimal grossIncome = taxCalculator.calculateGrossIncome(annualSalary);
    Assert.assertEquals(grossIncome, new BigDecimal(10000));
  }

  @Test
  public void calculateIncomeTax() throws Exception {
    BigDecimal incomeTax = taxCalculator.calculateIncomeTax(annualSalary);
    Assert.assertEquals(incomeTax, new BigDecimal(2696));
  }

  @Test
  public void calculateNetIncome() throws Exception {
    BigDecimal netIncome = taxCalculator.calculateNetIncome(annualSalary);
    Assert.assertEquals(netIncome, new BigDecimal(7304));
  }

  @Test
  public void calculateSuper() throws Exception {
    BigDecimal superannuation = taxCalculator.calculateSuper(annualSalary, new BigDecimal(0.1));
    Assert.assertEquals(superannuation, new BigDecimal(1000));
  }

}
