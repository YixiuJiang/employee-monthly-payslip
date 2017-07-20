package com.myob.payslip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayslipApplicationTest {

  @Autowired
  PayslipApplication payslipApplication;

  @Test
  public void testRun() throws Exception {
    payslipApplication.run();
  }

}
