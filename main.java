import java.util.ArrayList;
import java.util.Scanner;
class Book{
    String name;
    String author;
    int id;
    boolean isIssued;
    Book(String name, String Author, int id){
        this.name= name;
        this.author= Author;
        this.id= id;
this.isIssued = false;
    }
    @Override
public String toString(){
        String status = isIssued?"Issued": "Available";
        return id + " | "+ name + " | "+ author+" ("+status+").";
    }
}
public class Main {
    static ArrayList<Book>books = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("...Library Management System...");
        while (true){
        System.out.println("1. Add Book");
        System.out.println("2. View all Books");
        System.out.println("3.Remove Book");
        System.out.println("4.Search Book");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();
        if (user ==1){
            System.out.println("...Enter Book Details...");
            System.out.println();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();
            Book b = new Book(name,author,id);
            books.add(b);
            System.out.println("...Book Added...\n"+b);
        } else if (user==2) {
            if (books.isEmpty()){
                System.out.println("...No Book Found...");
            }else {
            System.out.println("...Here is the List of All Books...");
            for (int i=0; i<books.size(); i++){
                Book b = books.get(i);
                System.out.println(b);
            }
        }
        } else if (user==3) {
            System.out.println("...Enter ID of Book You want to Remove...");
            sc.nextLine();
            System.out.print("Enter ID: ");
            int rid = sc.nextInt();
            boolean found = false;
            for (int i=0; i<books.size();i++){
                Book b = books.get(i);
                if (b.id==rid){
                    books.remove(i);
                    System.out.println("...BOOK REMOVED SUCCESSFULLY...");
                    found=true;
                    break;
                }
            }if (!found)System.out.println("...Book Not found...");
        }
        else if (user == 4) {
            System.out.println("...Enter ID of Book You want to Search...");
            System.out.print("Enter ID: ");
            int sid = sc.nextInt();
            boolean found = false;

            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                if (b.id == sid) {
                    System.out.println("...BOOK FOUND...");
                    System.out.println(b);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("...Book Not Found...");
            }
        }

        else if (user==5){
            System.out.println("Exiting Bye...");
            break;
        }
}
    }
}
