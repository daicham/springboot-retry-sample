package com.daicham.springbootretrysample;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author daicham
 */
@Service
class RetryService {
    int count;

    @Retryable(
            value = { IllegalStateException.class },
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000))
    String doSomething() {
        if (System.currentTimeMillis() % 2 == 0) {
            count++;
            throw new IllegalStateException("error");
        }
        return "success[" + count + "]";
    }

    @Recover
    String recover(IllegalStateException e) {
        return e.getMessage();
    }
}
