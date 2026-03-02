import java.util.Scanner;

class TextState {
    String content;
    TextState next, prev;

    public TextState(String content) {
        this.content = content;
        next = prev = null;
    }
}

class TextEditor {
    TextState head = null;
    TextState current = null;
    int size = 0;
    int limit = 10;

    public void add(String text) {
        TextState s = new TextState(text);

        if (head == null) {
            head = current = s;
            size = 1;
        } else {
            current.next = s;
            s.prev = current;
            current = s;
            size++;

            if (size > limit) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        System.out.println("State saved");
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful");
        } else {
            System.out.println("No more undo available");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful");
        } else {
            System.out.println("No more redo available");
        }
    }

    public void display() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
        else
            System.out.println("No text available");
    }
}

public class Question_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int n = 0;

        while (n != 5) {
            System.out.println("Text Editor");
            System.out.println("1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");

            n = input.nextInt();
            input.nextLine();

            if (n == 1) {
                System.out.print("Enter Text: ");
                String text = input.nextLine();
                editor.add(text);
            }
            else if (n == 2) {
                editor.undo();
            }
            else if (n == 3) {
                editor.redo();
            }
            else if (n == 4) {
                editor.display();
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