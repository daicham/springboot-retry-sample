package com.daicham.springbootretrysample;

import org.springframework.stereotype.Service;

/**
 * @author daicham
 */
@Service
class RetryService {

    String doSomething() {
        return "success!";
    }
}
