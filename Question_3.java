import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    Task head = null;
    Task tail = null;
    Task cur = null;

    public void addTask(int id, String name, int priority, String date) {
        Task newTask = new Task(id, name, priority, date);

        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
            cur = head;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }

        System.out.println("Task added");
    }

    public void removeTask(int id) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Task temp = head;
        Task prev = tail;

        do {
            if (temp.taskId == id) {

                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    prev.next = temp.next;

                    if (temp == head)
                        head = temp.next;
                    if (temp == tail)
                        tail = prev;
                }

                System.out.println("Task removed");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found.");
    }

    public void nextTask() {
        if (cur == null) {
            System.out.println("No tasks available.");
            return;
        }

        displayTask(cur);
        cur = cur.next;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Task temp = head;
        boolean flag = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                flag = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!flag)
            System.out.println("Result not found");
    }

    private void displayTask(Task t) {
        System.out.println("Task ID: " + t.taskId);
        System.out.println("Task Name: " + t.taskName);
        System.out.println("Priority: " + t.priority);
        System.out.println("Due Date: " + t.dueDate);
    }
}

public class Question_3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CircularTaskList list = new CircularTaskList();
        int choice = 0;

        while (choice != 6) {

            System.out.println("Welcome to Task Scheduler");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task by ID");
            System.out.println("3. View Current Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Search by Priority");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter Task ID: ");
                int id = input.nextInt();
                input.nextLine();
                System.out.print("Enter Task Name: ");
                String name = input.nextLine();
                System.out.print("Enter Priority: ");
                int priority = input.nextInt();
                input.nextLine();
                System.out.print("Enter Due Date: ");
                String date = input.nextLine();

                list.addTask(id, name, priority, date);
            }
            else if (choice == 2) {
                System.out.print("Enter Task ID to remove: ");
                int id = input.nextInt();
                list.removeTask(id);
            }
            else if (choice == 3) {
                list.nextTask();
            }
            else if (choice == 4) {
                list.displayAll();
            }
            else if (choice == 5) {
                System.out.print("Enter Priority: ");
                int p = input.nextInt();
                list.searchByPriority(p);
            }
            else if (choice == 6) {
                System.out.println("Exiting...........");
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        input.close();
    }
}