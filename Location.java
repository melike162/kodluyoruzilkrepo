package Paket4.C_5;


import java.util.Scanner;

public abstract class Location {
    public int LocID;
    private Player player; // oyuncuyu sınıfın içine atmış oluyoruz
    private String locationName;
    protected Scanner input= new Scanner(System.in); // böylece bütün alt sınıflarında kullanabiliriz!!!!

    public Location(Player player, String locationName, int LocID) {
        this.player = player;
        this.locationName = locationName;
        this.LocID=LocID;


    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocID() {
        return LocID;
    }

    public void setLocID(int locID) {
        LocID = locID;
    }
}
