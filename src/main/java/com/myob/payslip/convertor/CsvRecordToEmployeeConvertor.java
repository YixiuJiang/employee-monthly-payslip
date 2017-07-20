package com.myob.payslip.convertor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.myob.payslip.models.Employee;

@Component
public class CsvRecordToEmployeeConvertor implements Converter<CSVRecord, Employee> {

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

  private static final Logger LOGGER =
      LoggerFactory.getLogger(CsvRecordToEmployeeConvertor.class);

  @Override
  public Employee convert(CSVRecord csvRecord) {
    Employee employee = new Employee();
    try {
      employee.setFirstName(csvRecord.get(0));
      employee.setLastName(csvRecord.get(1));
      employee.setAunualSalary(new BigDecimal(csvRecord.get(2)));
      employee.setSuperRate(getSuperRateFromSuperRatePercentage(csvRecord.get(3)));
      employee.setPaymentPeriod(csvRecord.get(4));
      setEmployeePaymentStartDateAndPaymentEndDate(csvRecord.get(4), employee);
      if (employee.getPaymentStartDate().getDayOfMonth()!=1){

      }
    } catch (Exception e) {
      LOGGER.error("can't parse CSV record {} to employee.", csvRecord.toString(), e);
    }
    return employee;
  }

  private BigDecimal getSuperRateFromSuperRatePercentage(String superRatePercentage) {
    return new BigDecimal(superRatePercentage.trim().replace("%", ""))
        .divide(BigDecimal.valueOf(100));
  }

  private void setEmployeePaymentStartDateAndPaymentEndDate(
      String paymentStartDateAndPaymentEndDate, Employee employee) {
    String[] startEndDateArr = paymentStartDateAndPaymentEndDate.split("–");
    // append default year to date to parse date
    String startDate = startEndDateArr[0].trim() + " " + LocalDate.now().getYear();
    String endDate = startEndDateArr[1].trim() + " " + LocalDate.now().getYear();
    employee.setPaymentStartDate(LocalDate.parse(startDate, formatter));
    employee.setPaymentEndDate(LocalDate.parse(endDate, formatter));

  }
}
