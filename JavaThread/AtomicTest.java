package JavaThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jackie on 17-6-26.
 */
public class AtomicTest {

    private static AtomicInteger ai = new AtomicInteger(0);
    private static int ThreadCount = 20;
    public static CountDownLatch cdl = new CountDownLatch(20);

    public static void main(String args[]){
        for(int i=0;i<ThreadCount;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        ai.incrementAndGet();
                    }
                    cdl.countDown();
                }
            });
            thread.start();
        }
        try {
            cdl.await();
        }catch (Exception e){
            ;
        }
        System.out.println(ai.get());
    }
}
