import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkList {
    Student head;

    public void addStart(int rollNo, String name, int age, String grade) {
        Student st = new Student(rollNo, name, age, grade);
        st.next = head;
        head = st;
        System.out.println("Student added at beginning.");
    }

    public void addEnd(int rollNo, String name, int age, String grade) {
        Student st = new Student(rollNo, name, age, grade);

        if (head == null) {
            head = st;
            System.out.println("Student added at end.");
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = st;
        System.out.println("Student added at end.");
    }

    public void addAtPosition(int rollNo, String name, int age, String grade, int idx) {
        if (idx <= 0) {
            System.out.println("Invalid Position!");
            return;
        }

        Student st = new Student(rollNo, name, age, grade);

        if (idx == 1) {
            st.next = head;
            head = st;
            System.out.println("Student added at position 1.");
            return;
        }

        Student temp = head;
        for (int i = 1; i < idx - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position!");
            return;
        }

        st.next = temp.next;
        temp.next = st;
        System.out.println("Student added at position " + idx);
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted.");
        }
    }

    public void searchByRollNo(int rollNo) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    public void update(int rollNo, String newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.println("Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class Question_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentLinkList list = new StudentLinkList();

        int choice = 0;

        while (choice != 8) {
            System.out.println("Welcome to Student Record Management");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll No");
            System.out.println("5. Search Student by Roll No");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            if (choice == 1 || choice == 2 || choice == 3) {

                System.out.print("Enter Roll No: ");
                int roll = input.nextInt();
                input.nextLine();

                System.out.print("Enter Name: ");
                String name = input.nextLine();

                System.out.print("Enter Age: ");
                int age = input.nextInt();
                input.nextLine();

                System.out.print("Enter Grade: ");
                String grade = input.nextLine();

                if (choice == 1) {
                    list.addStart(roll, name, age, grade);
                } 
                else if (choice == 2) {
                    list.addEnd(roll, name, age, grade);
                } 
                else {
                    System.out.print("Enter Position: ");
                    int pos = input.nextInt();
                    list.addAtPosition(roll, name, age, grade, pos);
                }

            } 
            else if (choice == 4) {
                System.out.print("Enter Roll No to delete: ");
                list.deleteByRollNo(input.nextInt());
            } 
            else if (choice == 5) {
                System.out.print("Enter Roll No to search: ");
                list.searchByRollNo(input.nextInt());
            } 
            else if (choice == 6) {
                System.out.print("Enter Roll No: ");
                int r = input.nextInt();
                input.nextLine();
                System.out.print("Enter New Grade: ");
                String newGrade = input.nextLine();
                list.update(r, newGrade);
            } 
            else if (choice == 7) {
                list.display();
            } 
            else if (choice == 8) {
                System.out.println("Exiting...");
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}