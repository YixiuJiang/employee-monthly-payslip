package com.myob.payslip.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import com.myob.payslip.builder.EmployeeBuilder;
import com.myob.payslip.builder.PayslipBuilder;
import com.myob.payslip.convertor.CsvRecordToEmployeeConvertor;
import com.myob.payslip.convertor.EmployeeToPayslipConvertor;

public class PayslipServiceTest {

  @InjectMocks
  private PayslipService subject;

  private String inputCSVFile = "/testInput.csv";

  private String outputCSVFile = "out.csv";

  @Mock
  private CsvRecordToEmployeeConvertor csvRecordToEmployeeConvertor;

  @Mock
  private EmployeeToPayslipConvertor employeeToPayslipConvertor;

  @Before
  public void setUp() throws Exception {
    subject = new PayslipService();
    MockitoAnnotations.initMocks(this);

  }

  @Test
  public void testGeneratePayslips() throws Exception {
    ReflectionTestUtils.setField(subject, "inputCSVFile", inputCSVFile);
    ReflectionTestUtils.setField(subject, "outputCSVFile", outputCSVFile);
    Mockito.when(csvRecordToEmployeeConvertor.convert(Mockito.any())).thenReturn(EmployeeBuilder.build());
    Mockito.when(employeeToPayslipConvertor.convert(Mockito.any())).thenReturn(PayslipBuilder.build());
    subject.generatePayslips();
  }

}
