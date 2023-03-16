package hometask_3_JavaCore.task2;


 public class Counter {

    private static Counter instance = new Counter();
    private static int count = 0;

     public Counter() {
     }

     public static Counter getInstance() {
        return instance;
    }

    public void increment() {
         count++;
    }

    public void decrement() {
         count--;
    }

     public static int getCount() {
         return count;
     }
 }
