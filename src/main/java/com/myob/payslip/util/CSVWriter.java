package com.myob.payslip.util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.myob.payslip.models.Payslip;

public class CSVWriter {

  private static final Logger LOGGER = LoggerFactory.getLogger(CSVReader.class);

  public static void writeCsvFile(File file, List<Payslip> payslips) {
    FileWriter fileWriter = null;
    CSVPrinter csvFilePrinter = null;
    CSVFormat csvFileFormat = CSVFormat.DEFAULT;
    try {
      fileWriter = new FileWriter(file);
      csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
      //Write a new student object list to the CSV file
      for (Payslip payslip : payslips) {
        List csvDataRecord = new ArrayList();
        csvDataRecord.add(payslip.getEmployee().getName());
        csvDataRecord.add(payslip.getEmployee().getPaymentPeriod());
        csvDataRecord.add(payslip.getGrossIncome());
        csvDataRecord.add(payslip.getIncomeTax());
        csvDataRecord.add(payslip.getNetIncome());
        csvDataRecord.add(payslip.getSuperannuation());
        csvFilePrinter.printRecord(csvDataRecord);
      }
      LOGGER.info("CSV file generated here ", file.getAbsolutePath());
    } catch (Exception e) {
      LOGGER.error("Error in CsvFileWriter!" + e);
    } finally {
      try {
        fileWriter.flush();
        fileWriter.close();
        csvFilePrinter.close();
      } catch (Exception e) {
        LOGGER.error("Error while flushing/closing fileWriter/csvPrinter!" + e);
      }
    }
  }

}
