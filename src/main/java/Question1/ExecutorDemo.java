package Question1;

import java.util.concurrent.*;

class Task implements Runnable {
    private int value;

    public Task(int value) {
        this.value = value;
    }

    public void run() {
        System.out.println("Value: " + value);
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int index = 0; index < 10; index++) {
            Task task = new Task(index);
            Future<?> future = executor.submit(task);
            try {
                future.get();
            }
            catch (Exception e)
            {
            }
        }
    }
}
