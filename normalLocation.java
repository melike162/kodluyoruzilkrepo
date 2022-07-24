package Paket4.C_5;


public abstract class normalLocation extends Location {



    public normalLocation(Player player, String locationName, int LocID) {
        super(player, locationName, LocID);
    }

    @Override
    public boolean onLocation() {
        return true;
    }


}