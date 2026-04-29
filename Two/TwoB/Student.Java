package TwoB; 

public class Student implements UserInterface { 
    @Override
    public String getRole() {
        return "Student user.";
    }

    @Override
    public void accessSystem() {
        System.out.println("Accessing the system as a student.");
    }
}

