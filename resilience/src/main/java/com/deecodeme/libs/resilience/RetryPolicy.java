package com.deecodeme.libs.resilience;

public interface RetryPolicy {
    boolean allowRetry(int retryCount, long elapsedTimeMs);
}
