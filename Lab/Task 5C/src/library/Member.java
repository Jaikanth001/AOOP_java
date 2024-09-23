package library;

public class Member {
    private final String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean borrowBook(Book book) {
        return book.borrowItem();
    }

    public boolean returnBook(Book book) {
        return book.returnItem();
    }
}
