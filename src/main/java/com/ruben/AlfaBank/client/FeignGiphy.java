package com.ruben.AlfaBank.client;

import com.ruben.AlfaBank.model.Giphy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Gif", url = "${giphy.url}")
public interface FeignGiphy {
    @GetMapping(value = "?api_key=" + "${giphy.api.key}" + "&tag=" + "{type}" + "&rating=g" ,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    Giphy gif(@PathVariable String type);

}
