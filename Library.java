import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class Library{
    public ArrayList<Book> library = new ArrayList<>();
    public void read()
    {
        try
        {
            Scanner s = new Scanner(new FileReader("books.txt"));
            while(s.hasNextLine())
            {
                String[] var = s.nextLine().split(",");
                String T = var[0];
                String A = var[1];
                int Y = Integer.parseInt(var[2]);
                Book obj = new Book(T, A, Y);
                library.add(obj);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void add()
    {
        String title,author;
        int Year;
        Scanner s=new Scanner(System.in);

        System.out.print("Enter the title of the book: ");
        title=s.next();
        System.out.println("Enter the author of the book: ");
        author=s.next();
        System.out.println("Enter the year of publication of the book");
        Year=s.nextInt();

        library.add(new Book(title, author, Year));
    }
    public void Delete()
    {
        if(library.isEmpty())
        {
            System.out.println("Library is empty!");
            return;
        }
        else
        {
            System.out.println("Enter the index to delete the book");
            Scanner s=new Scanner(System.in);
            int d=s.nextInt();
            d=d-1;
            String title,author;
            int Year;
            boolean flag=false;
            for(int i=0;i< library.size();i++)
            {
                if(d+1== library.size())
                {
                    library.remove(d);
                    System.out.println("Book deleted!");
                    break;
                }
                if(i==d&&flag==false)
                {
                    library.remove(d);
                    flag=true;
                    System.out.println("Book deleted!");
                }
                if(i>=d&&flag==true)
                {
                    Book b=library.get(i);
                    d++;
                    b.setId(d);
                }
            }
            if(flag==false)
            {
                System.out.println("Id invalid!");
            }
            else
            {
                Book b=library.get(library.size()-1);
                b.setNextId();
            }


        }

    }
    public void edit()
    {
        System.out.println("Enter the id of book to edit");
        Scanner s=new Scanner(System.in);
        int d=s.nextInt();


        if(library.isEmpty()||d> library.size())
        {
            System.out.println("Invalid id");
            return;
        }
        else
        {
            Book b=library.get(d-1);
            int c=0;
            while(true)
            {
                System.out.println("To edit\nPress 1 for title\nPress 2 for author\nPress 3 for publication year\nPress 4 to exit");
                c=s.nextInt();

                if(c==1)
                {
                    System.out.println("Enter new title");
                    String t=s.next();
                    b.setTitle(t);
                }
                if(c==2)
                {
                    System.out.println("Enter new author");
                    String t=s.next();
                    b.setAuthor(t);
                }
                if(c==3)
                {
                    System.out.println("Enter new author");
                    int t=s.nextInt();
                    b.setYear(t);
                }
                if(c==4)
                {
                    break;
                }
            }
        }
    }
    void display()
    {
        if(library.isEmpty())
        {
            System.out.println("Library is empty!");
            return;
        }
        else {
            for(int i=0;i< library.size();i++)
            {
                Book b=library.get(i);
                b.display();
            }
        }

    }
    void displaybtID()
    {
        System.out.println("Enter the id of book to view");
        Scanner s=new Scanner(System.in);
        int d=s.nextInt();
        if(library.isEmpty())
        {
            System.out.println("Library is empty!");
            return;
        }
        else if(d> library.size())
        {
            System.out.println("Invalid id");
            return;
        }
        else {
            Book b=library.get(d-1);
            b.display();
        }
    }
}