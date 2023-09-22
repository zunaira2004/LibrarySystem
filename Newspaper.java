public class Newspaper extends Item{
    public String company;
    public String date;
    public Newspaper(String t, String c, String d,int pc)
    {
        super(t,pc,0);
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
    @Override
    public void display()
    {
        super.display();
        System.out.println(" Publisher Company: "+company+" Date: "+date+ " Popularity count: "+popularity_count);
    }

    @Override
    public void costCalculation() {
        cost=10+5;
        System.out.println("The cost for borrowing this newspaper is: "+cost);

    }
}
