package com.daicham.springbootretrysample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daicham
 */
@RestController
public class IndexController {

    @Autowired
    RetryService retryService;

    @Autowired
    RetryTemplateService retryTemplateService;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return retryService.doSomething();
    }

    @GetMapping("/retry/template")
    @ResponseBody
    public String retry() {
        return retryTemplateService.doSomething();
    }
}
