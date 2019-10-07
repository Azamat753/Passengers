import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

        public static final int Passenger = 100;
        public static CountDownLatch latch;

        public static void main (String[]args) throws InterruptedException {
            latch = new CountDownLatch(Passenger);

            Semaphore sem = new Semaphore(4);

            for (int i = 1; i < 101; i++) {
                new Passenger(sem, i, latch).start();
            }
            latch.await();
            System.out.println("Можно ехать");
        }
    }
