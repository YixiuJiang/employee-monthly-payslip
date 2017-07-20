package com.myob.payslip.builder;

import java.math.BigDecimal;
import com.myob.payslip.models.Payslip;

public class PayslipBuilder {

  public static Payslip build() {
    Payslip payslip = new Payslip();
    payslip.setEmployee(EmployeeBuilder.build());
    payslip.setGrossIncome(new BigDecimal(5004));
    payslip.setIncomeTax(new BigDecimal(922));
    payslip.setSuperannuation(new BigDecimal(111));
    return payslip;
  }
}
