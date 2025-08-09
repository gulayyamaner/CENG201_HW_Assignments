package homework;

public class BorrowQueue {

    private Node front;
    private Node rear;
    private int size = 0;

    private static class Node {
        BorrowRequest request;
        Node next;

        Node(BorrowRequest request) {
            this.request = request;
            this.next = null;
        }
    }

    public void enqueue(BorrowRequest request) {
        Node newNode = new Node(request);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public BorrowRequest dequeue() {
        if (front == null) {
            return null; 
        }
        BorrowRequest request = front.request;
        front = front.next;
        if (front == null) {
            rear = null; 
        }
        size--;
        return request;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        System.out.println("\n--- Current Borrowing Requests ---");
        if (front == null) {
            System.out.println("The queue is empty.");
            return;
        }
        Node current = front;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.request.toString());
            current = current.next;
            count++;
        }
        System.out.println("----------------------------------");
    }
    
    public static void main(String[] args) {
        BorrowQueue queue = new BorrowQueue();

        System.out.println("Step 1: Adding 10 requests to the queue...");
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(new BorrowRequest(200 + i, 100 + i));
            System.out.println("Enqueued request for user " + (200 + i));
        }
        queue.printQueue();

        System.out.println("\nStep 2: Processing 3 requests...");
        for (int i = 0; i < 3; i++) {
            BorrowRequest processedRequest = queue.dequeue();
            if (processedRequest != null) {
                System.out.println("Processed: " + processedRequest.toString());
            }
        }

        System.out.println("\nStep 3: Printing remaining queue...");
        queue.printQueue();
    }
}
