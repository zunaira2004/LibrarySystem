import java.util.Scanner;
import java.util.ArrayList;
public class Book {
    public static int nextId;
    public int id;
    public String title;
    public String author;
    public int year;

    public Book(String t, String a,int y)
    {
        id = nextId++;
        title = t;
        author = a;
        year = y;
    }
    void setId(int d)
    {
        id=d;
    }
    void setTitle(String t)
    {
        title=t;
    }
    void setAuthor(String a)
    {
        author=a;
    }
    void setYear(int y)
    {
        year=y;
    }
    void setNextId()
    {
        nextId--;
    }
    public void display() {
        System.out.println("ID: "+id+" Title: "+title+" by "+author+"("+year+")");
    }
    static {
        nextId = 1;
    }

    public static void main(String[] args)
    {
        Library l=new Library();

        Scanner s=new Scanner(System.in);
        int choice=0;

        l.read();

        while (true)
        {
            System.out.println("Loaded books from file books.txt\n\nLibrary Management System Menu:\n1. Add Book\n2. " +
                    "Edit Book\n3. Delete Book\n4. View All Book\n5. View Book by Id\n6. Exit\n\nEnter your choice:");
            choice=s.nextInt();
            if(choice==1)
            {
                l.add();
            }
            if(choice==2)
            {
                l.edit();
            }
            if(choice==3)
            {
                l.Delete();
            }
            if(choice==4)
            {
                l.display();
            }
            if(choice==5)
            {
                l.displaybtID();
            }
            if(choice==6)
            {
                break;
            }
        }

    }

};


