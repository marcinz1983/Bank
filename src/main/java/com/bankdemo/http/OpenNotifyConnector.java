package com.bankdemo.http;


import java.net.URI;
import java.net.http.HttpRequest;

public class OpenNotifyConnector {

    private static final HttpRequest currentlyValidTableOfExchangeRates  =
            HttpRequest.newBuilder().GET().uri(URI.create("http://api.nbp.pl/api/exchangerates/tables/A/?format=json")).build();



}
