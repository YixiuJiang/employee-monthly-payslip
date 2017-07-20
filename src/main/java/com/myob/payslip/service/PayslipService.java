package com.myob.payslip.service;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.myob.payslip.convertor.CsvRecordToEmployeeConvertor;
import com.myob.payslip.convertor.EmployeeToPayslipConvertor;
import com.myob.payslip.models.Employee;
import com.myob.payslip.models.Payslip;
import com.myob.payslip.util.CSVReader;
import com.myob.payslip.util.CSVWriter;

@Service
public class PayslipService {

  @Value("${inputCSVFile}")
  private String inputCSVFile;

  @Value("${outputCSVFile}")
  private String outputCSVFile;

  @Autowired
  private CsvRecordToEmployeeConvertor csvRecordToEmployeeConvertor;

  @Autowired
  private EmployeeToPayslipConvertor employeeToPayslipConvertor;

  public void generatePayslips() {
    List<Employee> employees = getEmployees();
    List<Payslip> payslips = buildPayslips(employees);
    writePayslipsCSV(payslips);
  }


  private List<Employee> getEmployees() {
    List<Employee> employees = new ArrayList();

    List<CSVRecord> csvRecords = CSVReader.readCsvRecord(getInputCSVFile());
    if (!CollectionUtils.isEmpty(csvRecords)) {
      employees = getEmployeessFromCsvRecords(csvRecords);
    }
    return employees;
  }

  private File getInputCSVFile() {
    File csvFile;
    URL fileURL = getClass().getResource(inputCSVFile);
    if (fileURL == null) {
      csvFile = new File(inputCSVFile);
    } else {
      csvFile = new File(fileURL.getFile());
    }
    return csvFile;
  }

  private File getOutCSVFile() {
    File csvFile = new File(outputCSVFile);
    return csvFile;
  }

  private void writePayslipsCSV(List<Payslip> payslips) {
    CSVWriter.writeCsvFile(getOutCSVFile(), payslips);
  }

  private List<Payslip> buildPayslips(List<Employee> employees) {
    return employees.stream().map(employee -> employeeToPayslipConvertor.convert(employee))
        .collect(Collectors.toList());
  }

  private List<Employee> getEmployeessFromCsvRecords(List<CSVRecord> csvRecords) {
    return csvRecords.stream()
        .map(csvRecord -> csvRecordToEmployeeConvertor.convert(csvRecord))
        .collect(Collectors.toList());
  }

}
