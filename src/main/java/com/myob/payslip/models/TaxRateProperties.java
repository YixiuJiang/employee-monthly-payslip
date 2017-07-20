package com.myob.payslip.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "taxrate")
public class TaxRateProperties {

  private List<TaxRate> rates = new ArrayList<>();

  public List<TaxRate> getRates() {
    return rates;
  }

  public void setRates(List<TaxRate> rates) {
    this.rates = rates;
  }
}
