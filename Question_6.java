import java.util.Scanner;

class Process {
    int pid, burstTime;
    Process next;

    public Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        next = null;
    }
}

class RoundRobin {
    Process head = null, tail = null;

    public void addProcess(int id, int bt) {
        Process p = new Process(id, bt);
        if (head == null) {
            head = tail = p;
            p.next = head;
        } else {
            tail.next = p;
            p.next = head;
            tail = p;
        }
    }

    public void execute(int quantum) {
        if (head == null) {
            System.out.println("No processes");
            return;
        }

        Process temp = head;
        do {
            if (temp.burstTime > 0) {
                System.out.println("Executing P " + temp.pid);
                temp.burstTime -= quantum;
                if (temp.burstTime < 0)
                    temp.burstTime = 0;
                System.out.println("Remaining Burst : " + temp.burstTime);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class Question_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RoundRobin rr = new RoundRobin();
        int choice = 0;

        while (choice != 3) {
            System.out.println("\n1.Add Process\n2.Execute\n3.Exit");
            choice = input.nextInt();

            if (choice == 1) {
                System.out.print("PID: ");
                int id = input.nextInt();
                System.out.print("Burst Time: ");
                int bt = input.nextInt();
                rr.addProcess(id, bt);
            }
            else if (choice == 2) {
                System.out.print("Time Quantum: ");
                int q = input.nextInt();
                rr.execute(q);
            }
            else if (choice == 3) {
                System.out.println("Exiting...");
            }
        }
        input.close();
    }
}