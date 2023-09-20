import java.util.ArrayList;
import java.util.Scanner;

public class Item implements Configuration {
    public String title;
    public static int nextId = 1;
    public int id;
    public Boolean isBorrowed;
    public Item() {
    }
    public void setAuthor(String a) {
    }
    public void setYear(int y) {
    }
    public void setCompany(String c) {
    }
    public void setDate(String d) {
    }
    public Item(String t) {
        title = t;
        id = nextId++;
        isBorrowed=false;
    }
    public void display() {
        System.out.print("ID: " + id + " Title: " + title);
    }
    void setId(int d) {
        id = d;
    }
    int getId() {
        return id;
    }
    void setNextId() {
        nextId--;
    }
    void setTitle(String t) {
        title = t;
    }
    public static void main(String[] args) {
        Library l = new Library();

        Scanner s = new Scanner(System.in);
        int choice = 0;

        l.read();

        while (true) {
            System.out.println("Library Management System Menu:\n1. Add Item\n2. " +
                    "Edit Item\n3. Delete Item\n4. View All Items\n5. View Item by Id\n6. Borrow item" +
                    "\n7. View Borrower List\n8. Exit \n\nEnter your choice:");
            choice = s.nextInt();
            if (choice == 1) {
                l.add();
            }
            if (choice == 2) {
                l.edit();
            }
            if (choice == 3) {
                l.Delete();
            }
            if (choice == 4) {
                l.display();
            }
            if (choice == 5) {
                System.out.println("Enter the id of book to view");
                int d = s.nextInt();
                l.displaybtID(d);
            }
            if (choice == 6)
            {
                l.borrowItem();
            }
            if(choice==7)
            {
                l.borrowerList();
            }
            if (choice == 8) {
                break;
            }
        }
    }
}
