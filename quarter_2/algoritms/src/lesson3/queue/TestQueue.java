package lesson3.queue;

public class TestQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new QueueImpl<>(4);

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();

        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());

        queue.display();

        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));
        System.out.println("add element: " + queue.insert(17));

        queue.display();

        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        queue.display();

        System.out.println(5 / 2);
    }
}
