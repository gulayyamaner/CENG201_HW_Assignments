package homework;

public class BorrowRequest {
    int userId;
    int bookId;
    long requestTime;

    public BorrowRequest(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.requestTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", requestTime=" + requestTime +
                '}';
    }
}
