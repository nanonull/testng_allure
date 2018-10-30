package com.qa_test_lab.web.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class WebHelper {

    public static final Logger LOGGER = LoggerFactory.getLogger(WebHelper.class);

    public static final long IMPLICIT_TIMEOUT_SEC = 10;
    public static final Duration IMPLICIT_TIMEOUT_DURATION = Duration.ofSeconds(IMPLICIT_TIMEOUT_SEC);
    public static final long PAGE_LOAD_TIMEOUT_SEC = 15;
    public static final long SCRIPT_TIMEOUT_SEC = 15;

    public static void repeatUntilSuccess(int pollingIntervalMillis, long timeoutSeconds, Callable<Boolean> booleanCallable) {
        AtomicReference<Throwable> lastException = new AtomicReference<>();
        try {
            new FluentWait<>(booleanCallable)
                    .pollingEvery(Duration.ofMillis(pollingIntervalMillis))
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .until((Function<Callable<Boolean>, Object>) callable -> {
                        try {
                            return callable.call();
                        } catch (Exception | AssertionError e) {
                            LOGGER.info("repeatUntilSuccess: {}", e.getClass().getSimpleName());
                            lastException.set(e);
                            return false;
                        }
                    });
        } catch (TimeoutException waitTimeout) {
            LOGGER.error("Not possible to execute action with {} seconds timeout\n\n", timeoutSeconds);
            Throwable lastError = lastException.get();
            if (lastError != null) {
                LOGGER.error(lastError.getMessage() + "\n\n", lastError);
            }
            throw waitTimeout;
        }
    }
    public static void repeatUntilSuccess(int pollingIntervalMillis, Callable<Boolean> booleanCallable) {
        repeatUntilSuccess(pollingIntervalMillis, WebHelper.IMPLICIT_TIMEOUT_SEC, booleanCallable);
    }
}
