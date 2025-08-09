package homework;

public class BookList {

    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node {
        Book book;
        Node next;

        Node(Book book) {
            this.book = book;
            this.next = null;
        }
    }

    public void addBook(Book book) {
        Node newNode = new Node(book);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Added: " + book.title);
    }

    public boolean removeBook(int id) {
        if (head == null) {
            return false; 
        }

        if (head.book.id == id) {
            System.out.println("Removed: " + head.book.title);
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.book.id != id) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("Removed: " + current.next.book.title);
            if (current.next == tail) {
                tail = current; 
            }
            current.next = current.next.next;
            size--;
            return true;
        }

        return false; 
    }

    public Book findBook(int id) {
        Node current = head;
        while (current != null) {
            if (current.book.id == id) {
                System.out.println("Found book: " + current.book.toString());
                return current.book;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + id + " not found.");
        return null;
    }

    public void printList() {
        System.out.println("\n--- Library Book List ---");
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.book.toString());
            current = current.next;
            count++;
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        BookList library = new BookList();

        System.out.println("Step 1: Adding 5 books...");
        library.addBook(new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(102, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(103, "Martin Eden", "Jack London"));
        library.addBook(new Book(104, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(105, "The Catcher in the Rye", "J.D. Salinger"));
        library.printList();
        

        System.out.println("\nStep 2: Removing book with ID 103...");
        library.removeBook(103);

        System.out.println("\nStep 3: Searching for book with ID 104...");
        library.findBook(104);
        System.out.println("\nStep 3: Searching for book with ID 199 (not present)...");
        library.findBook(199);

        System.out.println("\nStep 4: Printing final list...");
        library.printList();
    }
}