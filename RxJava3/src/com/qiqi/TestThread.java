package com.qiqi;

import java.util.concurrent.ScheduledThreadPoolExecutor;

class TestThread {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(0);
        for (int i = 0; i < 10; i++) {
            int index = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Log.e("i=" + index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
