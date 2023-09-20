public class Borrower extends Item{
    public String borrower;
    public int id;

    public Borrower()
    {
        borrower=null;
    }
    public Borrower(String b,int d) {
        borrower = b;
        id=d+1;
    }
    public void displayBorrower()
    {
        System.out.println("Name: "+borrower+"\nId of borrowed item: "+id);
    }
}
