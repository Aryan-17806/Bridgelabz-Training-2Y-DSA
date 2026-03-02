import java.util.Scanner;

class Book {
    String title, author, genre;
    int bookId;
    boolean available;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        next = prev = null;
    }
}

class Library {
    Book head = null, tail = null;

    public void addBook(String t, String a, String g, int id, boolean av) {
        Book book = new Book(t, a, g, id, av);
        if (head == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
        System.out.println("Book added.");
    }

    public void removeBook(int id) {
        Book temp = head;

        while (temp != null && temp.bookId != id)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head)
            head = head.next;
        if (temp == tail)
            tail = tail.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;

        System.out.println("Book removed.");
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void display() {
        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayRev() {
        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    public void count() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    private void displayBook(Book b) {
        System.out.println("Title: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Genre: " + b.genre);
        System.out.println("ID: " + b.bookId);
        System.out.println("Available: " + b.available);
    }
}

public class Question_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library lib = new Library();
        int n = 0;

        while (n != 7) {
            System.out.println("Welcome to Library Management");
            System.out.println("1.Add Book");
            System.out.println("2.Remove Book");
            System.out.println("3.Search by Title");
            System.out.println("4.Update Availability");
            System.out.println("5.Display Forward & Reverse");
            System.out.println("6.Count Books");
            System.out.println("7.Exit");

            n = input.nextInt();
            input.nextLine();

            if (n == 1) {
                System.out.print("Title: ");
                String t = input.nextLine();
                System.out.print("Author: ");
                String a = input.nextLine();
                System.out.print("Genre: ");
                String g = input.nextLine();
                System.out.print("Book ID: ");
                int id = input.nextInt();
                System.out.print("Available (true/false): ");
                boolean av = input.nextBoolean();
                lib.addBook(t, a, g, id, av);
            }
            else if (n == 2) {
                System.out.print("Enter Book ID: ");
                lib.removeBook(input.nextInt());
            }
            else if (n == 3) {
                System.out.print("Enter Title: ");
                lib.searchByTitle(input.nextLine());
            }
            else if (n == 4) {
                System.out.print("Book ID: ");
                int id = input.nextInt();
                System.out.print("New Status (true/false): ");
                boolean st = input.nextBoolean();
                lib.updateAvailability(id, st);
            }
            else if (n == 5) {
                lib.display();
                System.out.println("Reverse:");
                lib.displayRev();
            }
            else if (n == 6) {
                lib.count();
            }
            else if (n == 7) {
                System.out.println("Exiting...");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        input.close();
    }
}