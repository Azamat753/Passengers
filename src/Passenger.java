import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread{
    Semaphore sem;
    int id;
    CountDownLatch latch;

    Passenger(Semaphore sem, int id, CountDownLatch LATCH){
        this.sem = sem;
        this.id = id;
        this.latch = LATCH;

    }
    public synchronized void run()  {
        try {
            sem.acquire();
            System.out.println("Пассажир " + id + " покупает билет");
            System.out.println("Пассажир "+ id + " садится в автобус");
            sem.release();
            latch.countDown();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
