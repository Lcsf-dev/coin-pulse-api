package com.example.CoinPulse.singleton;

public class SystemTrackerSingleton {
    private int totalRequests = 0;

    private SystemTrackerSingleton() {}

    private static class Holder {
        private static final SystemTrackerSingleton INSTANCE = new SystemTrackerSingleton();
    }

    public static SystemTrackerSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void incrementRequests() {
        totalRequests++;
        System.out.println("[SINGLETON] Total de consultas nesta sessão: " + totalRequests);
    }
}