package com.deecodeme.libs.resilience;

public class RetryOnce extends AbstractRetry {
    private final long timeBetweenRetriesMs;

    public RetryOnce(long timeBetweenRetriesMs) {
        super(1);
        this.timeBetweenRetriesMs = timeBetweenRetriesMs;
    }

    @Override
    public long getSleepTimeMs(int retryCount, long elapsedTimeMs) {
        return this.timeBetweenRetriesMs;
    }
}
