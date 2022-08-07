package Paket7_Collection_CokSıkKullanılıyor_ONEMLI.Odev1;

import java.awt.*;

public class Book implements Comparable<Book>{
    private String name;
    private int pageNumber;
    private String writerName;
    private int releaseDate;

    public Book(String name, int pageName, String writerName, int releaseDate) {
        this.name = name;
        this.pageNumber = pageName;
        this.writerName = writerName;
        this.releaseDate = releaseDate;
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

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    void com(List String){

    }


    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }
}
