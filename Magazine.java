import java.util.ArrayList;

public class Magazine extends Item{
    public ArrayList<String> author;
    public String Publisher;
    public String authorName;

    public Magazine(String t, ArrayList<String> a, String p,int pc,int c)
    {
        super(t,pc,c);
        author=new ArrayList<>();
        author.addAll(a);
        Publisher=p;
    }
    public ArrayList<String> getAuthor()
    {
        return author;
    }
    public void setAuthor(ArrayList<String> a)
    {
        author.addAll(a);
    }
    public void setauthor(String a,int d)
    {
        author.set(d,a);
    }
    public void displayAuthors()
    {
        for(int i=0;i< author.size();i++)
        {
            System.out.println((i+1) +". "+author.get(i));
        }
    }
    public void setPublisher(String p)
    {
        Publisher=p;
    }
    @Override
    public void display()
    {
        super.display();
        System.out.print(" by ");
        for(int i=0;i<author.size();i++)
        {
            System.out.print(author.get(i)+" ");
        }
        System.out.println("Published by " + Publisher+ " Cost: "+cost+" Popularity count: "+popularity_count);
    }

    @Override
    public void costCalculation() {
        cost=cost*popularity_count;
        System.out.println("The cost for borrowing this book is: "+cost);

    }
}
