package com.myob.payslip.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.myob.payslip.models.Employee;
import com.myob.payslip.models.Payslip;
import com.myob.payslip.service.TaxCalculator;

@Component
public class EmployeeToPayslipConvertor implements Converter<Employee, Payslip> {
  @Autowired
  private TaxCalculator taxCalculator;

  @Override
  public Payslip convert(Employee employee) {
    Payslip payslip = new Payslip();
    payslip.setEmployee(employee);
    payslip.setIncomeTax(taxCalculator.calculateIncomeTax(employee.getAunualSalary()));
    payslip.setGrossIncome(taxCalculator.calculateGrossIncome(employee.getAunualSalary()));
    payslip.setSuperannuation(taxCalculator.calculateSuper(employee.getAunualSalary(),employee.getSuperRate()));
    payslip.setNetIncome(taxCalculator.calculateNetIncome(employee.getAunualSalary()));
    return payslip;  }
}
