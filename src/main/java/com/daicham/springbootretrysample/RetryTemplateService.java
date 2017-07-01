package com.daicham.springbootretrysample;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

/**
 * @author daicham
 */
@Service
public class RetryTemplateService {
    String doSomething() {
        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.registerListener(new RetryListener() {
            @Override
            public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
                System.out.println("opened");
                return true;
            }

            @Override
            public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                System.out.println("closed");
            }

            @Override
            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                System.out.println("onError:" + throwable.getMessage());
            }
        });
        return retryTemplate.execute(new RetryCallback<String, IllegalStateException>() {
            @Override
            public String doWithRetry(RetryContext context) throws IllegalStateException {
                if (System.currentTimeMillis() % 2 == 0) {
                    throw new IllegalStateException("error");
                }
                return "success!!!!";
            }
        }, new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext context) throws Exception {
                return "recovery!";
            }
        });
    }
}
