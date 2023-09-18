import java.util.Scanner;
import java.util.ArrayList;
public class Book extends Item
{
    public String author;
    public int year;
    public Book(String t, String a,int y)
    {
        super(t);
        author = a;
        year = y;
    }
    public void setAuthor(String a)
    {
        author=a;
    }
    public void setYear(int y)
    {
        year=y;
    }
    void setId(int d)
    {
        super.setId(d);
    }

    public void display()
    {
        super.display();
        System.out.println(" by "+author+"("+year+")");
    }


};


