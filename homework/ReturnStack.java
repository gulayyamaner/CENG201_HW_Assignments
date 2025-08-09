package homework;

public class ReturnStack {

    private Node top;
    private int size = 0;

    private static class Node {
        ReturnRequest request;
        Node next;

        Node(ReturnRequest request) {
            this.request = request;
        }
    }

    public void push(ReturnRequest request) {
        Node newNode = new Node(request);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public ReturnRequest pop() {
        if (top == null) {
            return null; 
        }
        ReturnRequest request = top.request;
        top = top.next;
        size--;
        return request;
    }

    public ReturnRequest peek() {
        if (top == null) {
            return null;
        }
        return top.request;
    }

    public void printStack() {
        System.out.println("\n--- Current Return Requests (Top to Bottom) ---");
        if (top == null) {
            System.out.println("The stack is empty.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current.request.toString());
            current = current.next;
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        ReturnStack stack = new ReturnStack();
        
        System.out.println("Step 1: Pushing 5 return requests...");
        for (int i = 1; i <= 5; i++) {
            stack.push(new ReturnRequest(300 + i));
            System.out.println("Pushed return for book ID " + (300 + i));
        }
        stack.printStack();

        System.out.println("\nStep 2: Popping 2 requests...");
        for (int i = 0; i < 2; i++) {
            ReturnRequest processedRequest = stack.pop();
            if (processedRequest != null) {
                System.out.println("Processed: " + processedRequest.toString());
            }
        }

        System.out.println("\nStep 3: Printing remaining stack...");
        stack.printStack();
    }
}
