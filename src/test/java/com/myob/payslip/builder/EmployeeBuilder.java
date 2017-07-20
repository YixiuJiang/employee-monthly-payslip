package com.myob.payslip.builder;

import java.math.BigDecimal;
import com.myob.payslip.models.Employee;

public class EmployeeBuilder {

  public static Employee build() {
    String firstName = "David";
    String lastName = "Rudd";
    String anuualSalary = "60000";
    String paymentPeriod = "01 March\t– 31 March";
    Employee employee = new Employee();
    employee.setLastName(lastName);
    employee.setFirstName(firstName);
    employee.setPaymentPeriod(paymentPeriod);
    employee.setAunualSalary(new BigDecimal(anuualSalary));
    return employee;
  }

}
