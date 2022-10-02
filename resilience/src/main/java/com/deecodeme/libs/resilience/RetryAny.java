package com.deecodeme.libs.resilience;

public class RetryAny extends AbstractRetry {
    private int timeBetweenRetriesMs;

    public RetryAny(int maxCount, int timeBetweenRetriesMs) {
        super(maxCount);
        this.timeBetweenRetriesMs = timeBetweenRetriesMs;
    }

    @Override
    public long getSleepTimeMs(int retryCount, long elapsedTimeMs) {
        return this.timeBetweenRetriesMs;
    }
}
