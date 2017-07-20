package com.myob.payslip.util;

import java.io.File;
import java.net.URL;
import java.util.List;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.client.ExpectedCount;

public class CSVReaderTest {


  @Test
  public void readCsvRecord() throws Exception {
    URL fileURL = getClass().getResource("/testInput.csv");
    File csvFile = new File(fileURL.getFile());
    List<CSVRecord> csvRecordList = CSVReader.readCsvRecord(csvFile);
    Assert.assertEquals(csvRecordList.size(), 2);
  }
}
