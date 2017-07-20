package com.myob.payslip.util;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.myob.payslip.builder.PayslipBuilder;
import com.myob.payslip.models.Employee;
import com.myob.payslip.models.Payslip;

public class CSVWriterTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void writeCsvFile() throws Exception {
    File tempFile = File.createTempFile("testOutPut", "csv");
    CSVWriter.writeCsvFile(tempFile, Arrays.asList(PayslipBuilder.build()));
    tempFile.delete();
  }
}
