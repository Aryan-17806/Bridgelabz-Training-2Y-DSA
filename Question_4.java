import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    Item head;

    public void addItem(String name, int id, int quantity, double price) {
        Item item = new Item(name, id, quantity, price);

        if (head == null) {
            head = item;
        } else {
            Item temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = item;
        }
        System.out.println("Item added.");
    }

    public void removeItem(int id) {
        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.id != id)
            temp = temp.next;

        if (temp.next == null)
            System.out.println("Result not found");
        else {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int id, int quantity) {
        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Result not found");
    }

    public void searchItem(int id) {
        Item temp = head;

        while (temp != null) {
            if (temp.id == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Result not found");
    }

    public void totalValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    public void displayAll() {
        Item temp = head;

        if (temp == null) {
            System.out.println("Empty List");
            return;
        }

        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item i) {
        System.out.println("Item Name: " + i.name);
        System.out.println("Item ID: " + i.id);
        System.out.println("Quantity: " + i.quantity);
        System.out.println("Price: " + i.price);
    }
}

public class Question_4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        InventoryList list = new InventoryList();
        int n = 0;

        while (n != 6) {

            System.out.println("Welcome to Inventory Management");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Display & Total Value");
            System.out.println("6. Exit");
            
            n = input.nextInt();
            input.nextLine();

            if (n == 1) {
                System.out.print("Enter Item Name: ");
                String name = input.nextLine();
                System.out.print("Enter Item ID: ");
                int id = input.nextInt();
                System.out.print("Enter Quantity: ");
                int q = input.nextInt();
                System.out.print("Enter Price: ");
                double p = input.nextDouble();
                list.addItem(name, id, q, p);
            }
            else if (n == 2) {
                System.out.print("Enter Item ID: ");
                list.removeItem(input.nextInt());
            }
            else if (n == 3) {
                System.out.print("Enter Item ID: ");
                int id = input.nextInt();
                System.out.print("Enter New Quantity: ");
                int q = input.nextInt();
                list.updateQuantity(id, q);
            }
            else if (n == 4) {
                System.out.print("Enter Item ID: ");
                list.searchItem(input.nextInt());
            }
            else if (n == 5) {
                list.displayAll();
                list.totalValue();
            }
            else if (n == 6) {
                System.out.println("Exiting...");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        input.close();
    }
}