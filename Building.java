public class Building {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    /* This is a constructor for the Building class */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }
    /**
     * An accessor for name
     * @return this.name which is the name of a building
     */
    public String getName() {
        return this.name;
    }

    /**
     * An accessor for address
     * @return this.address which is the address of a building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * An accessor for floors
     * @return this.nFloors which is the nunber of floors in a building
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Alters the default toString() method when calling on an object.
     * @return a string describing the building
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
