package JavaThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jackie on 17-6-23.
 */
public class VolateleTest {
    public static volatile int race = 0;
    public static void increase(){
        race++;
    }

    // 等待多线程完成的类COuntDownLatch, JDK并发包中的一个
    static CountDownLatch cd  =new CountDownLatch(20);
    private static final int THREADS_COUNT = 20;

    public static void main(String args[]){
        Thread [] threads = new Thread[THREADS_COUNT];
        for(int i=0;i <THREADS_COUNT;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        increase();
                    }
                    cd.countDown();
                }
            });
            threads[i].start();
        }

        try {
            cd.await();
        }catch (Exception e){
            ;
        }

        System.out.println(race);
    }
}
