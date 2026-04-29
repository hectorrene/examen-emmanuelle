package TwoB; 

public class Admin implements UserInterface { 
    @Override
    public String getRole() {
        return "Admin user.";
    }

    @Override
    public void accessSystem() {
        System.out.println("Accessing the system as an admin.");
    }
}

