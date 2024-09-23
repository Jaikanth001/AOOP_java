package library;

public class Book implements Borrowable {
    private final String title;
    private final String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    @Override
    public boolean borrowItem() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
