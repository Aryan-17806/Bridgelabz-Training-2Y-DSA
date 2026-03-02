import java.util.*;

class User {
    int id;
    String name;
    int age;
    LinkedList<Integer> friends;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        friends = new LinkedList<>();
    }
}

public class Question_7 {
    static ArrayList<User> users = new ArrayList<>();

    static User findUser(int id) {
        for (User u : users)
            if (u.id == id)
                return u;
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n1.Add User\n2.Add Friend\n3.Remove Friend\n4.Display Friends\n5.Count Friends\n6.Exit");
            choice = input.nextInt();

            if (choice == 1) {
                System.out.print("User ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("Name: ");
                String name = input.nextLine();
                System.out.print("Age: ");
                int age = input.nextInt();
                users.add(new User(id, name, age));
            }
            else if (choice == 2) {
                System.out.print("User1 ID: ");
                int id1 = input.nextInt();
                System.out.print("User2 ID: ");
                int id2 = input.nextInt();
                User u1 = findUser(id1);
                User u2 = findUser(id2);
                if (u1 != null && u2 != null) {
                    u1.friends.add(id2);
                    u2.friends.add(id1);
                    System.out.println("Friend added.");
                }
            }
            else if (choice == 3) {
                System.out.print("User1 ID: ");
                int id1 = input.nextInt();
                System.out.print("User2 ID: ");
                int id2 = input.nextInt();
                User u1 = findUser(id1);
                User u2 = findUser(id2);
                if (u1 != null && u2 != null) {
                    u1.friends.remove(Integer.valueOf(id2));
                    u2.friends.remove(Integer.valueOf(id1));
                    System.out.println("Friend removed.");
                }
            }
            else if (choice == 4) {
                System.out.print("User ID: ");
                int id = input.nextInt();
                User u = findUser(id);
                if (u != null)
                    System.out.println("Friends: " + u.friends);
            }
            else if (choice == 5) {
                for (User u : users)
                    System.out.println("User " + u.id + " has " + u.friends.size() + " friends.");
            }
            else if (choice == 6) {
                System.out.println("Exiting...");
            }
        }
        input.close();
    }
}