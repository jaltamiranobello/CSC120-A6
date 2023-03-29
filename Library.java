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
      try{
        if (this.collection.containsKey(title)){
          throw new RuntimeException("This book is already in the library cannot add again.");
        }
        this.collection.put(title, true);
      }
        catch(RuntimeException e){
          System.out.println(e);
        }
    }

    // return the title that we removed
    public String removeTitle(String title){
      try{
      if (!this.collection.containsKey(title)){
        throw new RuntimeException("This book is not in the library.");
      }
      this.collection.remove(title);
      }
      catch(RuntimeException e) {
        System.out.println(e);
      }
      return title;
    }

    public void checkOut(String title){
      try{
        if (!this.collection.containsKey(title)){
          throw new RuntimeException("This book is not in the library.");
        }
        else if(this.collection.get(title).equals(false)){
          throw new RuntimeException("This book is currently checked out sorry.");
        }
        this.collection.replace(title, false);
        System.out.println(title + " was successfully checked-out!");
        }
        catch(RuntimeException e) {
          System.out.println(e);
        }
      }

    public void returnBook(String title){
      try{
        if(!this.collection.containsKey(title)){
          throw new RuntimeException("Cannot return " + title + " because the library does not own this.");
        }
        else if(this.collection.get(title).equals(true)){
          throw new RuntimeException("This book has already been returned to the library.");
        }
        this.collection.replace(title, true);
        System.out.println(title + " was successfully returned!");
        }

        catch(RuntimeException e){
          System.out.println(e);
        }
  
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
      neilson.checkOut("The Cat in The Hat By Dr. Seuss");
      neilson.checkOut("The Cat in The Hat By Dr. Seuss");
      neilson.checkOut("The Bible");
      neilson.returnBook("The Cat in The Hat By Dr. Seuss");
      neilson.returnBook("The Cat in The Hat By Dr. Seuss");
      neilson.returnBook("The Bible");
      neilson.printCollection();


    }
  
  }