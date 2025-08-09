package homework;

public class LibrarySystem {

    private final BookList bookList;
    private final BorrowQueue priorityBorrowQueue;
    private final BorrowQueue normalBorrowQueue;
    private final ReturnStack returnStack;

    public LibrarySystem() {
        this.bookList = new BookList();
        this.priorityBorrowQueue = new BorrowQueue();
        this.normalBorrowQueue = new BorrowQueue();
        this.returnStack = new ReturnStack();
    }

    public void addBook(Book book) {
        bookList.addBook(book);
    }

    public void addBorrowingRequest(BorrowRequest request) {
        if (request.isPriority) {
            priorityBorrowQueue.enqueue(request);
            System.out.println("Added PRIORITY request for user: " + request.userId);
        } else {
            normalBorrowQueue.enqueue(request);
            System.out.println("Added normal request for user: " + request.userId);
        }
    }

    public void addReturnRequest(ReturnRequest request) {
        returnStack.push(request);
        System.out.println("Added return request for book: " + request.bookId);
    }

    public void processBorrowingRequest() {
        BorrowRequest requestToProcess = null;
        if (priorityBorrowQueue.size() > 0) {
            requestToProcess = priorityBorrowQueue.dequeue();
            System.out.print("Processing PRIORITY request -> ");
        } else if (normalBorrowQueue.size() > 0) {
            requestToProcess = normalBorrowQueue.dequeue();
            System.out.print("Processing NORMAL request -> ");
        }

        if (requestToProcess != null) {
            System.out.println("Processed: " + requestToProcess.toString());
            addReturnRequest(new ReturnRequest(requestToProcess.bookId));
        } else {
            System.out.println("No borrowing requests to process.");
        }
    }

    public void printSystemState() {
        System.out.println("\n\n=============== SYSTEM STATE ===============");
        bookList.printList();
        System.out.println("\n--- Priority Borrowing Requests ---");
        priorityBorrowQueue.printQueue();
        System.out.println("\n--- Normal Borrowing Requests ---");
        normalBorrowQueue.printQueue();
        returnStack.printStack();
        System.out.println("==========================================\n");
    }
    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();

        System.out.println("Step 1: Adding 10 books...");
        for (int i = 1; i <= 10; i++) {
            system.addBook(new Book(100 + i, "Book Title " + i, "Author " + i));
        }
        
        System.out.println("\nStep 2: Adding borrowing requests...");
        system.addBorrowingRequest(new BorrowRequest(201, 101, false));
        system.addBorrowingRequest(new BorrowRequest(202, 102, true)); // Priority
        system.addBorrowingRequest(new BorrowRequest(203, 103, false));
        system.addBorrowingRequest(new BorrowRequest(204, 104, true)); // Priority
        system.addBorrowingRequest(new BorrowRequest(205, 105, false));
        system.addBorrowingRequest(new BorrowRequest(206, 106, false));
        system.addBorrowingRequest(new BorrowRequest(207, 107, true)); // Priority
        system.addBorrowingRequest(new BorrowRequest(208, 108, false));

        System.out.println("\nStep 3: Adding initial return requests...");
        system.addReturnRequest(new ReturnRequest(901));
        system.addReturnRequest(new ReturnRequest(902));
        
        system.printSystemState();

        System.out.println("\nStep 4: Processing 3 borrowing requests...");
        system.processBorrowingRequest();
        system.processBorrowingRequest();
        system.processBorrowingRequest();

        System.out.println("\nStep 5: Printing final system state...");
        system.printSystemState();
    }
}
