package com.myob.payslip.convertor;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.myob.payslip.builder.EmployeeBuilder;
import com.myob.payslip.models.Employee;
import com.myob.payslip.models.Payslip;
import com.myob.payslip.service.TaxCalculator;

public class EmployeeToPayslipConvertorTest {

  @InjectMocks
  private EmployeeToPayslipConvertor subject;

  @Mock
  private TaxCalculator taxCalculator;

  @Before
  public void setUp() throws Exception {
    subject = new EmployeeToPayslipConvertor();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testConvert() throws Exception {
    Mockito.when(taxCalculator.calculateGrossIncome(Mockito.any()))
        .thenReturn(new BigDecimal(10000));
    Mockito.when(taxCalculator.calculateIncomeTax(Mockito.any())).thenReturn(new BigDecimal(1000));
    Mockito.when(taxCalculator.calculateNetIncome(Mockito.any())).thenReturn(new BigDecimal(800));
    Mockito.when(taxCalculator.calculateSuper(Mockito.any(), Mockito.any()))
        .thenReturn(new BigDecimal(1000));
    Employee employee = EmployeeBuilder.build();
    Payslip payslip = subject.convert(employee);
    Assert.assertEquals(payslip.getEmployee(),employee);
    Assert.assertEquals(payslip.getGrossIncome(), new BigDecimal(10000));
    Assert.assertEquals(payslip.getIncomeTax(), new BigDecimal(1000));
    Assert.assertEquals(payslip.getNetIncome(), new BigDecimal(800));
    Assert.assertEquals(payslip.getSuperannuation(), new BigDecimal(1000));

  }

}
