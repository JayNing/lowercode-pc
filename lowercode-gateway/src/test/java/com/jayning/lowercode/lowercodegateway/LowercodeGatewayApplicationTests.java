package com.jayning.lowercode.lowercodegateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LowercodeGatewayApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10 * 1000L);
                System.out.println("子线程");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //如果t1设置成守护线程，则进程会随着主线程执行结束，而关闭，不会执行子线程。
        //如果t1不是守护线程，则进程不会随着主线程执行结束而关闭，而且会等到执行完子线程后，才会关闭。
        t1.setDaemon(true);
        System.out.println("主线程执行结束。。。。");
    }
}
