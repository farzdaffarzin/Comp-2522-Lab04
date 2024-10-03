package ca.bcit.comp2522.lab4;

/**
 * <p>
 * The Name class represents a person's name, consisting of a first name and a last name.
 * It implements the Printable interface to provide a method for displaying the full name.
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
    private final int MAX_NAME_LENGTH = 50;

    /**
     * Constructor for the Name class.
     *
     * @param firstName of the person
     * @param lastName  of the person
     */
    Name(final String firstName,
         final String lastName) {

        validator(firstName, lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * validating all the inputs are not null, blank and less than 50 characters
     *
     * @param firstName the birthdate
     * @param lastName  the name
     */
    private void validator(final String firstName,
                           final String lastName) {

        if(firstName == null || lastName == null) {
            throw new NullPointerException("first name or last name cannot be null");
        }

        if(firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("first name or last name cannot be blank");
        }

        if(firstName.length() > MAX_NAME_LENGTH || lastName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("first name length must be less than 50 characters");
        }
    }

    /**
     * Uses the Printable interface
     *
     * @return the full name of the person
     */
    @Override
    public String display() {

        return firstName +
                " " +
                lastName;
    }

    /**
     * Gets the first name of the person.
     *
     * @return the first name of the person.
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the last name of the person.
     */
    public String getLastName() {

        return lastName;
    }
}
