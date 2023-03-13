package Question2;

public class Counter
{
    private static volatile int counter=0;
    void incrementCounter(){
        counter++;
    }
    int printCounter(){
        return counter;
    }

    public static void main(String[] args) {

        Counter Counter = new Counter();
        Thread mainThread = new Thread(()->{
            while (counter < 10) {
                Counter.incrementCounter();
                System.out.println("Counter changed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }

        });

        Thread secondThread = new Thread(()->{
            while(counter<10) {
                System.out.println("Incremented Value is : "+ Counter.printCounter());
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                }

            }
        });
        mainThread.start();
        secondThread.start();
    }
}