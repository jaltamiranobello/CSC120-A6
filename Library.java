import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {
    private Hashtable <String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable <String, Boolean> ();
    }

    /** Accessor for collection */
    public Hashtable <String, Boolean> getCollection(){
      return this.collection;
    }


    public void addTitle(String title){
      this.collection.put(title, true);
    }

    // return the title that we removed
    public String removeTitle(String title){
      this.collection.remove(title);
      return title;
    }

    public void checkOut(String title){
      // make sure we have the book to even check it out
      this.collection.replace(title, false);
    }

    public void returnBook(String title){
      this.collection.replace(title, true);
    }

    // returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        return true;
      }
      else{
        return false;
      }
      
    }
    
    // returns true if the title is currently available, false otherwise
    public boolean isAvailable(String title){
      if(this.collection.get(title).equals(true)){
        return true;
      }
      else{
        return false;
      }
    }

    public String toString() {
      String description = super.toString();
      description += ". There are currently " + this.collection.size() + " books in this collection.";
      return description;
    }

    // prints out the entire collection in an easy-to-read way (including checkout status)
    public void printCollection() {
      System.out.println(this.collection.toString());
    } 



    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "7 Smith St", 4);
      neilson.addTitle("The Cat in The Hat By Dr. Seuss");
      System.out.println(neilson);
      neilson.printCollection();


    }
  
  }