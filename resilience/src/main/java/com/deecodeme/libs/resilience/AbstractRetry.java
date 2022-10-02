package com.deecodeme.libs.resilience;

public abstract class AbstractRetry implements RetryPolicy {
    private static final int DEFAULT_MAX_RETRY_COUNT = 3;
    private int maxRetryCount = DEFAULT_MAX_RETRY_COUNT;

    public AbstractRetry(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    @Override
    public boolean allowRetry(int retryCount, long elapsedTimeMs) {
        boolean isAllowed = false;
        if (retryCount < maxRetryCount) {
            try {
                Thread.sleep(getSleepTimeMs(retryCount, elapsedTimeMs));
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
            isAllowed = true;
        }
        return isAllowed;
    }

    public abstract long getSleepTimeMs(int retryCount, long elapsedTimeMs);
}
