import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class Library {
    public ArrayList<Item> library = new ArrayList<>();
    public ArrayList<Borrower> borrowers = new ArrayList<>();

    public void read()
    {
        try {
            Scanner s = new Scanner(new FileReader("books.txt"));
            String line;
            int count = 1;
            while (s.hasNextLine()) {
                line = s.nextLine();
                String[] var = line.split(",");

                if ("1".equals(var[0])) {
                    String T = var[count++];
                    String A = var[count++];
                    int Y = Integer.parseInt(var[count]);
                    Book obj = new Book(T, A, Y);
                    library.add(obj);
                    count = 1;
                } else if ("2".equals(var[0])) {
                    String T = var[count++];
                    ArrayList<String> authors = new ArrayList<>();

                    while (count < var.length && !var[count].contains(".")) {
                        authors.add(var[count++]);
                    }
                    authors.add(var[count++]);
                    String comp;
                    comp = var[count];
                    Magazine obj = new Magazine(T, authors, comp);
                    library.add(obj);
                    count = 1;
                } else if ("3".equals(var[0])) {
                    String T = var[count++];
                    String P = var[count++];
                    String D = var[count++];

                    Newspaper obj = new Newspaper(T, P, D);
                    library.add(obj);
                    count = 1;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add() {
        Scanner s = new Scanner(System.in);
        System.out.println("Which item do you want to add?");
        String c = s.next();
        if (c.equalsIgnoreCase("Book")||c.equalsIgnoreCase("books"))
        {
            String title, author;
            int Year;

            System.out.print("Enter the title of the book: ");
            title = s.next();
            System.out.println("Enter the author of the book: ");
            author = s.next();
            System.out.println("Enter the year of publication of the book");
            Year = s.nextInt();
            library.add(new Book(title, author, Year));
        }
        else if (c.equalsIgnoreCase("Magazines")||c.equalsIgnoreCase("Magazine")) {
            String title, publisher;
            ArrayList<String> m = new ArrayList<>();
            System.out.println("Enter the title of magazine");
            title = s.next();
            System.out.println("Enter the number of authors");
            int size = s.nextInt();
            String input;
            System.out.println("Enter the name of authors");
            for (int i = 0; i < size; i++) {
                input = s.next();
                m.add(input);
            }
            System.out.println("Enter the name of publisher");
            publisher = s.next();
            library.add(new Magazine(title, m, publisher));
        } else if (c.equalsIgnoreCase("Newspapers")||c.equalsIgnoreCase("newspaper")) {
            String title, publisher, date;
            System.out.println("Enter the name of title");
            title = s.next();
            System.out.println("Enter the name of publisher");
            publisher = s.next();
            System.out.println("Enter the date");
            date = s.next();
            library.add(new Newspaper(title, publisher, date));
        }
    }

    public void Delete() {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return;
        }
        else
        {
            System.out.println("Enter the index to delete the item");
            Scanner s = new Scanner(System.in);
            int d = s.nextInt();
            d = d - 1;
            boolean flag = false;
            if (d + 1 == library.size()) {
                library.remove(d);
                System.out.println("Item deleted!");
                flag=true;
            }
            else
            {
                for (int i = 0; i < library.size(); i++) {

                    if (i == d && flag == false) {
                        library.remove(d);
                        flag = true;
                        System.out.println("Item deleted!");
                    }
                    if (i >= d && flag == true) {
                        Item I = library.get(i);
                        d++;
                        I.setId(d);
                    }
                }
            }

            if (flag == false) {
                System.out.println("Id invalid!");
            } else {
                Item I = library.get(library.size() - 1);
                I.setNextId();
            }
        }

    }

    public void edit() {
        System.out.println("Enter the id of book to edit");
        Scanner s = new Scanner(System.in);
        int d = s.nextInt();


        if (library.isEmpty() || d > library.size()) {
            System.out.println("Invalid id");
            return;
        }
        else
        {
            Item I = library.get(d - 1);
            int c = 0;
            Scanner s1 = new Scanner(System.in);
            System.out.println("Which item do you want to edit?");
            String item = s1.next();

            if (item.equalsIgnoreCase("book")||item.equalsIgnoreCase("books")) {
                while (true) {
                    System.out.println("To edit\nPress 1 for title\nPress 2 for author\nPress 3 for publication year\nPress 4 to exit");
                    c = s.nextInt();

                    if (c == 1) {
                        System.out.println("Enter new title");
                        String t = s.next();
                        I.setTitle(t);
                    }
                    if (c == 2) {
                        System.out.println("Enter new author");
                        String t = s.next();
                        I.setAuthor(t);
                    }
                    if (c == 3) {
                        System.out.println("Enter new author");
                        int t = s.nextInt();
                        I.setYear(t);
                    }
                    if (c == 4) {
                        break;
                    }
                }
            }
            else if (item.equalsIgnoreCase("magazines")||item.equalsIgnoreCase("magazine"))
            {
                while(true)
                {
                    System.out.println("To edit\nPress 1 for Title\nPress 2 for authors\nPress 3 for publisher company\nPress 4 to exit");
                    c=s.nextInt();

                    if(c==1)
                    {
                        System.out.println("Enter new title");
                        String t = s.next();
                        I.setTitle(t);
                    }
                    if (c == 2) {

                        System.out.println("Which Author's Name do you want to edit?\n(Press 0 to exit)");
                        int author=s.nextInt();


                    }
                    if(c==3)
                    {
                        System.out.println("Enter new Publisher Company");
                        String comp=s.next();
                        I.setCompany(comp);
                    }
                    if(c==4)
                    {
                        break;
                    }
                }
            }
            else  if (item.equalsIgnoreCase("newspaper")||item.equalsIgnoreCase("newspapers"))
            {
                while (true) {
                    System.out.println("To edit\nPress 1 for Title\nPress 2 for Publisher Company\nPress 3 for Date\nPress 4 to exit");
                    c = s.nextInt();

                    if (c == 1) {
                        System.out.println("Enter new title");
                        String t = s.next();
                        I.setTitle(t);
                    }
                    if (c == 2) {
                        System.out.println("Enter new Publisher Company");
                        String t = s.next();
                        I.setCompany(t);
                    }
                    if (c == 3) {
                        System.out.println("Enter new author");
                        String t = s.next();
                        I.setDate(t);
                    }
                    if (c == 4) {
                        break;
                    }
                }
            }
        }
    }
    public Boolean borrowItem()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the id of the Item to borrow");
        int d=s.nextInt();
        d=d-1;
        if(d>library.size()||1>library.size())
        {
            System.out.println("Id does not exist!");
            return false;
        }
        Item I=library.get(d);
        Borrower b;
        if(I.isBorrowed==true)
        {
            System.out.println("Item is not availible!");
            return false;
        }
        else
        {
            System.out.println("Enter your name?");
            String name=s.next();
            if(I.isBorrowed==false)
            {
                borrowers.add(new Borrower(name,d));
                I.isBorrowed=true;
                return true;
            }
        }
        return false;
    }
    public void borrowerList()
    {
        Boolean flag=false;
        for(int i=0;i< borrowers.size();i++)
        {
           Borrower b=borrowers.get(i);
           b.displayBorrower();
        }
    }
    void display () {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return;
        } else {
            for (int i = 0; i < library.size(); i++) {
                Item I = library.get(i);
                I.display();
            }
        }
    }
    void displaybtID(int d)
    {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return;
        } else if (d > library.size()) {
            System.out.println("Invalid id");
            return;
        } else {
            Item I = library.get(d - 1);
            I.display();
        }
    }
}