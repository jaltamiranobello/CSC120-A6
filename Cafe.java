/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams; 
    private int nCups;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    public int getnCoffeeOunces(){
        return this.nCoffeeOunces;
    }

    public int getnSugarPackets(){
        return this.nSugarPackets;
    }

    public int getnCreams(){
        return this.nCreams;
    }

    public int getnCups(){
        return this.nCups;
    }
    
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        try {
            if (this.nCoffeeOunces <= size - 1 | this.nSugarPackets <= nSugarPackets - 1 | this.nCreams <= nCreams - 1 | this.nCups == 0){
                throw new RuntimeException("Sorry we don't have enough inventory to make the coffee. Please give us a moment and try again!");
            }

            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Thank you for your purchase!");
        }
         catch(RuntimeException e){
            System.out.println(e);
            this.restock(size, nSugarPackets, nCreams, 1);
         }
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (this.nCoffeeOunces < nCoffeeOunces){
            this.nCoffeeOunces = nCoffeeOunces;
        }
        if(this.nSugarPackets < nSugarPackets){
            this.nSugarPackets = nSugarPackets;
        }
        if (this.nCreams < nCreams){
            this.nCreams = nCreams;
        }
        if (this.nCups < nCups){
            this.nCups = nCups;
        }

    }
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 12, 4, 4, 2);
        myCafe.sellCoffee(12, 2, 2);
        myCafe.sellCoffee(16, 4, 4);
        myCafe.sellCoffee(12, 2, 2);
    }
    
}
