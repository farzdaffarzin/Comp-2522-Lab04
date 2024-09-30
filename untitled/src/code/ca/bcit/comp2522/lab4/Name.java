package ca.bcit.comp2522.lab4;

/**
 * <p>
 *
 * </p>
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 * @author Arsh Mann
 * @version 1.0
 */
public class Name implements Printable {

    private final String firstName;
    private final String lastName;

    /**
     * Constructor for the Name class.
     *
     * @param firstName of the person
     * @param lastName of the person
     */
    Name(final String firstName,
         final String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Uses the Printable interface
     * @return the full name of the person
     */
    @Override
    public String display(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
