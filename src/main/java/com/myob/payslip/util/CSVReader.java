package com.myob.payslip.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVReader {

  private static final Logger LOGGER = LoggerFactory.getLogger(CSVReader.class);

  public static List<CSVRecord> readCsvRecord(File csvFile) {
    List<CSVRecord> csvRecords;
    Reader fileReader = null;
    CSVParser csvFileParser = null;
    CSVFormat csvFileFormat = CSVFormat.DEFAULT;
    try {

      fileReader = new FileReader(csvFile);
      csvFileParser = new CSVParser(fileReader, csvFileFormat);
      csvRecords = csvFileParser.getRecords();
    } catch (IOException e) {
      throw new RuntimeException("Error in CsvFileReader!", e);
    } finally {
      try {
        fileReader.close();
        csvFileParser.close();
      } catch (IOException e) {
        LOGGER.error("Error while closing fileReader/csvFileParse!", e);
      }
    }
    return csvRecords;
  }
}
