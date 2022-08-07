package Paket7_Collection_CokSıkKullanılıyor_ONEMLI.Odev1;


import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> arr=new TreeSet<>();

        Book b1=new Book("Kürk Msntolu Madonna",177, "Sabahattin Ali", 1943);
        Book b2=new Book("Dijital Kale",400, "Dan Brown", 1998);
        Book b3=new Book("Sefiller",320, "Victor Hugo", 1862);
        Book b4=new Book("Suç ve Ceza",705, "Fyodor Dostoyevski", 1866);
        Book b5=new Book("Das Kapital",1000, "Karl Marx", 1867);

        arr.add(b1);
        arr.add(b2);
        arr.add(b3);
        arr.add(b4);
        arr.add(b5);

        for (Book book:arr) {
            System.out.println(book.getName()+"\t"+book.getPageNumber());
        }

        System.out.println("---------------------------------");
        TreeSet<Book> arr2 = new TreeSet<>(new Comparator<Book>() {

            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPageNumber() - b2.getPageNumber();
            }
        }.reversed());

        arr2.add(b1);
        arr2.add(b2);
        arr2.add(b3);
        arr2.add(b4);
        arr2.add(b5);

        for (Book book:arr2) {
            System.out.println(book.getName()+"\t"+book.getPageNumber());
        }
    }
}
