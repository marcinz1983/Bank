package com.bankdemo.converter;

import com.bankdemo.DTO.CurrencyExchangeRatesDTO;

public interface JsonMapper {
    CurrencyExchangeRatesDTO  mapCurrencyFromJson (String json);
}
