package com.ruben.AlfaBank.client;

import com.ruben.AlfaBank.model.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ExchangeClient", url = "${openexchangerates.url}")
public interface FeignOpenExchangeRates {
    @GetMapping(value = "/latest.json?app_id=" + "${openexchangerates.app.id}",
                consumes = MediaType.APPLICATION_JSON_VALUE)
    ExchangeRates getLatestRates();

    @GetMapping(value = "/historical/" + "{data}" +  ".json?app_id=" + "${openexchangerates.app.id}" + "&symbols=" + "{value}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ExchangeRates getHistoryRates(@PathVariable String data, @PathVariable String value);
}
