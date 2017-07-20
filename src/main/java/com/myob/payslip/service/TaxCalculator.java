package com.myob.payslip.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.myob.payslip.models.TaxRateProperties;

@Component
public class TaxCalculator {

  @Autowired
  private TaxRateProperties taxRateProperties;

  public BigDecimal calculateGrossIncome(BigDecimal annualSalary) {
    return annualSalary.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP)
        .setScale(0, BigDecimal.ROUND_HALF_UP);
  }

  public BigDecimal calculateIncomeTax(BigDecimal annualSalary) {
    List<BigDecimal> taxSteps = new ArrayList();
    taxRateProperties.getRates().stream().forEach(taxRate -> {
      if (taxRate.matchingRate(annualSalary.intValue())) {
        BigDecimal taxableIncome = annualSalary
            .subtract(new BigDecimal(taxRate.getTaxableIncomeStart()));
        if (annualSalary.intValue() > taxRate.getTaxableIncomeEnd()
            && taxRate.getTaxableIncomeEnd() != -1) {
          taxableIncome = new BigDecimal(
              taxRate.getTaxableIncomeEnd() - taxRate.getTaxableIncomeStart());
        }
        taxSteps.add(taxableIncome.multiply(new BigDecimal(taxRate.getRate())));
      }
    });
    BigDecimal totalIncome = taxSteps.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

    return totalIncome.divide(new BigDecimal(12), 2, BigDecimal.ROUND_HALF_UP)
        .setScale(0, BigDecimal.ROUND_HALF_UP);
  }

  public BigDecimal calculateNetIncome(BigDecimal annualSalary) {
    return calculateGrossIncome(annualSalary).subtract(calculateIncomeTax(annualSalary))
        .setScale(0, BigDecimal.ROUND_HALF_UP);
  }

  public BigDecimal calculateSuper(BigDecimal annualSalary, BigDecimal superRate) {
    return calculateGrossIncome(annualSalary).multiply(superRate)
        .setScale(0, BigDecimal.ROUND_HALF_UP);
  }

}
