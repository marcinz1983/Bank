package com.bankdemo.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyExchangeRatesDTO {

    private final List<TableOfCurrency> List0;

    @JsonCreator
    public CurrencyExchangeRatesDTO(@JsonProperty("0") List<TableOfCurrency> list0) {
        List0 = list0;
    }

    public List<TableOfCurrency> getList0() {
        return List0;
    }

    public static class TableOfCurrency {

    private final String no;

    private final String effectiveDate;

    private final List<CurrencyRates> rates;

        @JsonCreator
        public TableOfCurrency(@JsonProperty("no") String no,
                               @JsonProperty("effectiveDate") String effectiveDate,
                               @JsonProperty("rates")List<CurrencyRates> rates) {
            this.no = no;
            this.effectiveDate = effectiveDate;
            this.rates = rates;
        }

        public String getNo() {
            return no;
        }

        public String getEffectiveDate() {
            return effectiveDate;
        }

        public List<CurrencyRates> getRates() {
            return rates;
        }



        public static class   CurrencyRates{

            private final String currency;

            private final String code;

            private final Double mid;

            @JsonCreator
            public CurrencyRates(@JsonProperty("currency")String currency,
                                 @JsonProperty("code") String code,
                                 @JsonProperty("mid")Double mid) {
                this.currency = currency;
                this.code = code;
                this.mid = mid;
            }

            public String getCurrency() {
                return currency;
            }

            public String getCode() {
                return code;
            }

            public Double getMid() {
                return mid;
            }
        }


    }

}

