package library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        Member member = new Member("John Doe");
        library.addMember(member);

        if (member.borrowBook(book1)) {
            System.out.println(member.getName() + " borrowed " + book1.getTitle());
        }

        if (member.returnBook(book1)) {
            System.out.println(member.getName() + " returned " + book1.getTitle());
        }
    }
}
