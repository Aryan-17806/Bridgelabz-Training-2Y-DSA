import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int id, String customer, String movie, String seat, String time) {
        ticketId = id;
        customerName = customer;
        movieName = movie;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

class TicketSystem {
    Ticket head = null, tail = null;

    public void add(int id, String cust, String movie, String seat, String time) {
        Ticket t = new Ticket(id, cust, movie, seat, time);

        if (head == null) {
            head = tail = t;
            t.next = head;
        } else {
            tail.next = t;
            t.next = head;
            tail = t;
        }
        System.out.println("Ticket booked");
    }

    public void remove(int id) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head, prev = tail;

        do {
            if (temp.ticketId == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    prev.next = temp.next;
                    if (temp == head)
                        head = temp.next;
                    if (temp == tail)
                        tail = prev;
                }
                System.out.println("Ticket cancelled");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found");
    }

    public void display() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket temp = head;
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Customer: " + temp.customerName);
            System.out.println("Movie: " + temp.movieName);
            System.out.println("Seat: " + temp.seatNumber);
            System.out.println("Time: " + temp.bookingTime);
            temp = temp.next;
        while (temp != head);
    }

    public void count() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets: " + count);
    }
}

public class Question_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicketSystem system = new TicketSystem();
        int n = 0;

        while (n != 5) {
            System.out.println("Welcome to Ticket Reservation System");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Count Tickets");
            System.out.println("5. Exit");

            n = input.nextInt();
            input.nextLine();

            if (n == 1) {
                System.out.print("Ticket ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("Customer Name: ");
                String cust = input.nextLine();
                System.out.print("Movie Name: ");
                String movie = input.nextLine();
                System.out.print("Seat Number: ");
                String seat = input.nextLine();
                System.out.print("Booking Time: ");
                String time = input.nextLine();

                system.add(id, cust, movie, seat, time);
            }
            else if (n == 2) {
                System.out.print("Enter Ticket ID: ");
                system.remove(input.nextInt());
            }
            else if (n == 3) {
                system.display();
            }
            else if (n == 4) {
                system.count();
            }
            else if (n == 5) {
                System.out.println("Exiting...");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        input.close();
    }
}