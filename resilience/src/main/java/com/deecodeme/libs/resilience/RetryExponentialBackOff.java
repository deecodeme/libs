package com.deecodeme.libs.resilience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/*
Exponential backoff takes a base
 */
public class RetryExponentialBackOff extends AbstractRetry {
    private static final int MAX_RETRIES_LIMIT = 29;

    private Logger logger = LoggerFactory.getLogger(RetryExponentialBackOff.class.getName());
    private final long delayTimeMs;
    private final long maxDelayTimeMs;

    private final Random random = new Random();

    public RetryExponentialBackOff(long delayTimeMs, long maxDelayTimeMs) {
        this(delayTimeMs, maxDelayTimeMs, MAX_RETRIES_LIMIT);
    }

    public RetryExponentialBackOff(long delayTimeMs, long maxDelayTimeMs, int maxRetries) {
        super(maxRetries);
        this.delayTimeMs = delayTimeMs;
        this.maxDelayTimeMs = maxDelayTimeMs;
    }

    @Override
    public long getSleepTimeMs(int retryCount, long elapsedTimeMs) {
        long sleepTime = 0;
        long nextDelay = delayTimeMs * Math.max(1, random.nextInt(1 << (retryCount + 1)));
        if (nextDelay > maxDelayTimeMs) {
            sleepTime = nextDelay;
        }
        return sleepTime;
    }
}
