public class Newspaper extends Item{
    public String company;
    public String date;
    public Newspaper(String t, String c, String d)
    {
        super(t);
        company=c;
        date=d;
    }
    public void setCompany(String c)
    {
        company=c;
    }
    public void setDate(String d)
    {
        date=d;
    }
    public void display()
    {
        super.display();
        System.out.println(" Publisher Company: "+company+" Date: "+date);
    }
}
