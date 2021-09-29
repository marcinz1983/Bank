package com.bankdemo.controller;


import com.bankdemo.DTO.CurrencyDTO;
import com.bankdemo.converter.JacksonJsonMapper;
import com.bankdemo.services.Impl.CurrencyService;
import com.bankdemo.services.Impl.http.OpenNotifyConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
    private final CurrencyService currencyService;
    private final OpenNotifyConnector openNotifyConnector;

    HttpClient httpClient = HttpClient.newHttpClient();


    public final JacksonJsonMapper jsonMapper;

    private static final HttpRequest currentlyValidTableOfExchangeRates =
            HttpRequest.newBuilder().GET().uri(URI.create
                    ("http://api.nbp.pl/api/exchangerates/tables/A/?format=json")).build();


    public CurrencyController(CurrencyService currencyService, OpenNotifyConnector openNotifyConnector, JacksonJsonMapper jsonMapper) {
        this.currencyService = currencyService;
        this.openNotifyConnector = openNotifyConnector;

        this.jsonMapper = jsonMapper;
    }



    @GetMapping
    public List<CurrencyDTO> getAllCurrency() {
        return currencyService.findAllCurrency();
    }

    @GetMapping("/{id}")
    public CurrencyDTO getCurrencyById(@PathVariable("id") Long id) {
        return currencyService.findCurrencyById(id);
    }

    @PostMapping("/add")
    public CurrencyDTO addCurrency(@RequestBody CurrencyDTO toSave) {
        return currencyService.saveNewCurrency(toSave);
    }

    @PutMapping("/{id}")
    public CurrencyDTO replaceCurrency(@PathVariable("id") Long id, @RequestBody CurrencyDTO toReplace) {
        return currencyService.replaceCurrency(id, toReplace);
    }

    @PatchMapping("/{id}")
    public CurrencyDTO updateCurrency(@PathVariable("id") Long id, @RequestBody CurrencyDTO toUpdate) {
        return currencyService.updateCurrencyById(id, toUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable("id") Long id) {
        currencyService.deleteCurrencyById(id);
    }

}
