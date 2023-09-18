import java.util.ArrayList;

public class Magazine extends Item{
    public ArrayList<String> author;
    public String Publisher;
    public String authorName;

    public Magazine(String t, ArrayList<String> a, String p)
    {
        super(t);
        author=new ArrayList<>();
        author.addAll(a);
        Publisher=p;
    }
    public void setAuthor(ArrayList<String> a)
    {
        author.addAll(a);
    }
    public void setPublisher(String p)
    {
        Publisher=p;
    }
    public void display()
    {
        super.display();
        System.out.print(" by ");
        for(int i=0;i<author.size();i++)
        {
            System.out.print(author.get(i)+" ");
        }
        System.out.println("Published by " + Publisher);
    }

}
