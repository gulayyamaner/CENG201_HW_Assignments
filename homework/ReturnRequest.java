package homework;

public class ReturnRequest {
    int bookId;
    long returnTime;

    public ReturnRequest(int bookId) {
        this.bookId = bookId;
        this.returnTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "ReturnRequest{" +
                "bookId=" + bookId +
                ", returnTime=" + returnTime +
                '}';
    }
}    
