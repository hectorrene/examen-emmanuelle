package TwoB;

public class UserFactory {
    
    public static UserInterface createUser(String type) {
        if (type.equalsIgnoreCase("STUDENT")) {
            return new Student();
        } else if (type.equalsIgnoreCase("LIBRARIAN")) {
            return new Librarian();
        } else if (type.equalsIgnoreCase("ADMIN")) {
            return new Admin();
        }
        return null;
    }
}