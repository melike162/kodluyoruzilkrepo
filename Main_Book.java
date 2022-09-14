package Paket14_EnumSınıfları.Odev;

import java.util.*;
import java.util.stream.Collectors;

public class Main_Book {
    public static class Book {
        private String name;
        private int pageNumber;
        private String author;
        private int date;

        public Book(String name, int pageNumber, String author, int date) {
            this.name = name;
            this.pageNumber = pageNumber;
            this.author = author;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }
    }
    public static void main(String[] args) {
        ArrayList<Book> list=new ArrayList<>();
        list.add(new Book("Fahrenheit", 99, "Ray", 1956));
        list.add(new Book("Suc ve Ceza", 612, "Dostoyevski", 1925));
        list.add(new Book("Savaş ve Baris", 800, "Tolstoy", 1915));
        list.add(new Book("Denizler altinda yirmi bin fersah", 55, "Jules Verne", 1925));
        list.add(new Book("Tutunamayanlar", 550, "Oğuz Atay", 1950));
        list.add(new Book("Kuyucakli Yusuf", 145, "Sabahattin Ali", 1965));
        list.add(new Book("Metro 2023", 650, "Dmitry Glukhovsky", 2006));
        list.add(new Book("Momo", 69, "Ende", 1980));
        list.add(new Book("Hobbit", 565, "J.R.R Tolkien", 1940));
        list.add(new Book("Pamuk prenses", 45, "Bilinmiyor", 0));

        Map<String,String> list2=new HashMap<>();
        for (int i=0;i<list.size();i++){
            list2.put(list.get(i).getName(),list.get(i).getAuthor());
        }

        List<Book> list3=list.stream().filter(num->num.getPageNumber()>100).collect(Collectors.toList());

        int i=1;
        for (String contryKey: list2.keySet()){
            System.out.println(i+"- "+contryKey);
            i++;
        }

        System.out.println("-----------");
        System.out.println(list3.size());
        i=1;
        for (Book a: list3){
            System.out.println(i+"- "+a.getName());
            i++;
        }

    }
}
