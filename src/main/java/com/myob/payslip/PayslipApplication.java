package com.myob.payslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.myob.payslip.service.PayslipService;

@SpringBootApplication
public class PayslipApplication implements CommandLineRunner {

  @Autowired
  private PayslipService payslipService;

  @Override
  public void run(String... args) {
    payslipService.generatePayslips();
  }


  public static void main(String[] args) {
    SpringApplication.run(PayslipApplication.class, args);

  }
}
