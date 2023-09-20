import java.util.ArrayList;
import java.util.Scanner;

public class Item implements Configuration {
    public String title;
    public static int nextId = 1;
    public int id;
    public int popularity_count;
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
        popularity_count=0;
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
            System.out.println("Library Management System Menu:\n1. Hot Picks\n2. Borrow item" +
                    "\n3. Add Item\n4. Edit Item\n5. Delete Item\n6. View All Items" +
                    "\n7. View Item by Id\n8. View Borrower List\n9. Exit \n\nEnter your choice:");
            choice = s.nextInt();
            if (choice == 1) {
                l.hotPicks();
            }
            if (choice == 2) {
                l.borrowItem();
            }
            if (choice == 3) {
                l.add();
            }
            if (choice == 4) {
                l.edit();
            }
            if (choice == 5) {
                System.out.println("Enter the index to delete the item");
                int d = s.nextInt();
                l.Delete(d);
            }
            if (choice == 6)
            {
                l.display();
            }
            if(choice==7)
            {
                System.out.println("Enter the id of book to view");
                int d = s.nextInt();
                l.displaybtID(d);
            }
            if (choice == 8) {
                l.borrowerList();
            }
            if (choice == 9) {
                break;
            }
        }
    }
}
