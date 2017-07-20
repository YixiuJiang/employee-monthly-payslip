package com.myob.payslip.convertor;

import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import com.myob.payslip.models.Employee;

public class CsvRecordToEmployeeConvertorTest {

  private CsvRecordToEmployeeConvertor subject;

  private CSVRecord csvRecord;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    subject = new CsvRecordToEmployeeConvertor();

  }


  @Test
  public void testConvert() throws Exception {
    String firstName = "David";
    String lastName = "Rudd";
    String anuualSalary = "60000";
    String superRate = "9%";
    String paymentPeriod = "01 March\t– 31 March";
    StringJoiner joiner = new StringJoiner(",");
    joiner.add(firstName).add(lastName).add(anuualSalary).add(superRate).add(paymentPeriod);
    String csvLine = joiner.toString();
    CSVFormat csvFormat = CSVFormat.DEFAULT;

    CSVParser csvParser = new CSVParser(new BufferedReader(new StringReader(csvLine)), csvFormat);

    List<CSVRecord> csvRecordList = csvParser.getRecords();
    csvRecord = csvRecordList.get(0);

    Employee employee = subject.convert(csvRecord);
    Assert.assertEquals(employee.getFirstName(), firstName);
    Assert.assertEquals(employee.getLastName(), lastName);
    Assert.assertEquals(employee.getAunualSalary(), new BigDecimal(anuualSalary));
    Assert.assertEquals(employee.getSuperRate(), new BigDecimal("0.09"));
    Assert.assertEquals(employee.getPaymentStartDate().getDayOfMonth(), 1);
    Assert.assertEquals(employee.getPaymentStartDate().getMonthValue(), 3);
    Assert.assertEquals(employee.getPaymentEndDate().getDayOfMonth(), 31);
    Assert.assertEquals(employee.getPaymentEndDate().getMonthValue(), 3);
  }

  @Test(expected = RuntimeException.class)
  public void testConvertException() throws Exception {
    String firstName = "David";
    StringJoiner joiner = new StringJoiner(",");
    joiner.add(firstName);
    String csvLine = joiner.toString();
    CSVFormat csvFormat = CSVFormat.DEFAULT;

    CSVParser csvParser = new CSVParser(new BufferedReader(new StringReader(csvLine)), csvFormat);

    List<CSVRecord> csvRecordList = csvParser.getRecords();
    csvRecord = csvRecordList.get(0);
    subject.convert(csvRecord);
  }

}
