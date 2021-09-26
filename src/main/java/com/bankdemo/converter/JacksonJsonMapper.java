package com.bankdemo.converter;

import com.bankdemo.DTO.CurrencyExchangeRatesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JacksonJsonMapper implements JsonMapper{

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CurrencyExchangeRatesDTO mapCurrencyFromJson(String json) {

        try{
         return  this.objectMapper.readValue(json,CurrencyExchangeRatesDTO.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }




}
