package homework;

public class BorrowRequest {
    int userId;
    int bookId;
    long requestTime;
    boolean isPriority; 

    public BorrowRequest(int userId, int bookId, boolean isPriority) {
        this.userId = userId;
        this.bookId = bookId;
        this.isPriority = isPriority;
        this.requestTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", isPriority=" + isPriority +
                ", requestTime=" + requestTime +
                '}';
    }
}
