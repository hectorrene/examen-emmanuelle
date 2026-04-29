package TwoB; 

public class Librarian implements UserInterface { 
    @Override
    public String getRole() {
        return "Librarian user.";
    }

    @Override
    public void accessSystem() {
        System.out.println("Accessing the system as a librarian.");
    }
}

