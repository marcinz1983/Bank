package com.bankdemo.services.Impl.http;


import com.bankdemo.DTO.CurrencyExchangeRatesDTO;
import com.bankdemo.converter.JacksonJsonMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class OpenNotifyConnector {



    HttpClient client = HttpClient.newHttpClient();

    public   final JacksonJsonMapper jsonMapper;

    private static final HttpRequest currentlyValidTableOfExchangeRates  =
            HttpRequest.newBuilder().GET().uri(URI.create
                    ("http://api.nbp.pl/api/exchangerates/tables/A/?format=json")).build();



    public OpenNotifyConnector(  JacksonJsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }



    public  Optional<CurrencyExchangeRatesDTO> getCurrencyFromApi(){
        try{

            final var response = client.send(currentlyValidTableOfExchangeRates, HttpResponse.BodyHandlers.ofString());
          if(response.statusCode() == 200){
              return Optional.ofNullable(jsonMapper.mapCurrencyFromJson(response.body()));
          }

            return  Optional.empty();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }


    }


}
