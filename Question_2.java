import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    Movie head;
    Movie tail;

    public void addStart(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = m;
        } else {
            m.next = head;
            head.prev = m;
            head = m;
        }

        System.out.println("Movie added at Start");
    }

    public void addEnd(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);

        if (head == null) {
            head = tail = m;
        } else {
            tail.next = m;
            m.prev = tail;
            tail = m;
        }

        System.out.println("Movie added at end.");
    }

    public void addAtPosition(String title, String director, int year, double rating, int idx) {
        if (idx <= 0) {
            System.out.println("Invalid Position");
            return;
        }

        if (idx == 1) {
            addStart(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;

        for (int i = 1; i < idx - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newMovie;
        } else {
            tail = newMovie;
        }

        temp.next = newMovie;

        System.out.println("Movie added at position " + idx);
    }

    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie removed.");
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Result not found");
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating.");
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Movie temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Movie temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(Movie m) {
        System.out.println("Title: " + m.title);
        System.out.println("Director: " + m.director);
        System.out.println("Year: " + m.year);
        System.out.println("Rating: " + m.rating);
    }
}

public class Question_2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        MovieLinkedList list = new MovieLinkedList();
        int n = 0;

        while (n != 9) {

            System.out.println("Welcome to Movie Management System");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Forward & Reverse");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            n = input.nextInt();
            input.nextLine();

            if (n == 1 || n == 2 || n == 3) {

                System.out.print("Enter Title: ");
                String title = input.nextLine();
                System.out.print("Enter Director: ");
                String director = input.nextLine();
                System.out.print("Enter Year: ");
                int year = input.nextInt();
                System.out.print("Enter Rating: ");
                double rating = input.nextDouble();
                input.nextLine();

                if (n == 1)
                    list.addStart(title, director, year, rating);
                else if (n == 2)
                    list.addEnd(title, director, year, rating);
                else {
                    System.out.print("Enter Position: ");
                    int pos = input.nextInt();
                    list.addAtPosition(title, director, year, rating, pos);
                }

            } 
            else if (n == 4) {
                System.out.print("Enter Title to remove: ");
                String title = input.nextLine();
                list.removeByTitle(title);
            } 
            else if (n == 5) {
                System.out.print("Enter Director name: ");
                String director = input.nextLine();
                list.searchByDirector(director);
            } 
            else if (n == 6) {
                System.out.print("Enter Rating: ");
                double rating = input.nextDouble();
                list.searchByRating(rating);
            } 
            else if (n == 7) {
                System.out.print("Enter Title: ");
                String title = input.nextLine();
                System.out.print("Enter New Rating: ");
                double newRating = input.nextDouble();
                list.updateRating(title, newRating);
            } 
            else if (n == 8) {
                System.out.println("\nForward Display:");
                list.displayForward();
                System.out.println("\nReverse Display:");
                list.displayReverse();
            } 
            else if (n == 9) {
                System.out.println("Exiting...");
            } 
            else {
                System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}