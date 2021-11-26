package com.ruben.AlfaBank.contorller;

import com.ruben.AlfaBank.client.FeignGiphy;
import com.ruben.AlfaBank.client.FeignOpenExchangeRates;
import com.ruben.AlfaBank.sevice.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    FeignOpenExchangeRates feignOpenExchangeRates;

    @Autowired
    FeignGiphy feignGiphy;

    @Autowired
    Calculator calculator;


    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("page", feignOpenExchangeRates.getLatestRates().getRates());
        return "main";
    }

    @PostMapping()
    public String result(Model model, @RequestParam("type") String type){
        double now = feignOpenExchangeRates.getLatestRates().getRates().get(type);
        double after = feignOpenExchangeRates.getHistoryRates(calculator.getYesterdayDate(), type).getRates().get(type);
        String typeCal = calculator.calculate(now, after);
        String gifUrl = feignGiphy.gif(typeCal).getData()
                .getImages()
                .getOriginal()
                .get("url");
        model.addAttribute("type", type);
        model.addAttribute("typeCal", typeCal);
        model.addAttribute("gif", gifUrl);
        main(model);
        return "main";
    }
}
