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

        validator(firstName, lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * validating all the inputs are not null, blank and less than 50 characters
     * @param firstName the birthdate
     * @param lastName the name
     */
    private void validator(final String firstName ,
                           final String lastName) {

        if (firstName == null || lastName == null) {
            throw new NullPointerException("first name or last name cannot be null");
        }
        if(firstName.isBlank() || lastName.isBlank()){
            throw new IllegalArgumentException("first name or last name cannot be blank");
        }
        if(firstName.length() > 50 || lastName.length() > 50){
            throw new IllegalArgumentException("first name length must be less than 50 characters");
        }
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
