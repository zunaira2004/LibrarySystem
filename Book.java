import java.util.Scanner;
import java.util.ArrayList;
public class Book extends Item
{
    public String author;
    public int year;
    public Book(String t, String a,int y,int pc,int c)
    {
        super(t,pc,c);
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
    @Override
    public void display()
    {
        super.display();
        System.out.println(" by "+author+"("+year+")"+ " Cost: "+cost+" Popularity count: "+popularity_count);
    }

    @Override
    public void costCalculation() {
        cost=cost+(cost*20)/100+200;
        System.out.println("The cost for borrowing this book is: "+cost);

    }
};


