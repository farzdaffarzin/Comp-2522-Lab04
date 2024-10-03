package ca.bcit.comp2522.lab4;

/**
 * <p>Author class represents an author, which extends the Person class and
 * adds additional functionality for handling an author's genre.
 * This class is able to display the author's name, genre, reverse the name,
 * and compare authors based on their date of birth and genre.
 * Implements the Printable interface for displaying information and
 * the Comparable interface for sorting authors.
 * </p>
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 * @author Arsh Mann
 * @version 1.0
 */
public class Author extends Person implements Printable {

    private final String genre;
    private final int MAX_GENRE_LENGTH = 30;

    /**
     * Constructs an Author instance, initializing the date of birth, date of death, name, and genre.
     * Validates the genre, ensuring it is not null and has a length of 30 characters or fewer.
     *
     * @param dateOfBirth the birthdate of the author.
     * @param dateOfDeath the death date of the author (nullable).
     * @param name        the name of the author.
     * @param genre       the genre associated with the author's work.
     * @throws NullPointerException     if the genre is null.
     * @throws IllegalArgumentException if the genre exceeds 30 characters.
     */
    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre) {

        super(dateOfBirth, dateOfDeath, name);
        validate(genre);
        this.genre = genre;
    }

    /**
     * Validates if the genre is null or exceeds 30 characters.
     *
     * @param genre the genre of the author.
     * @throws NullPointerException     if the genre is null.
     * @throws IllegalArgumentException if the genre exceeds 30 characters.
     */
    private void validate(final String genre) {

        if(genre == null) {
            throw new NullPointerException("Genre is null");
        }

        if(genre.length() > MAX_GENRE_LENGTH) {
            throw new IllegalArgumentException("Genre must be less than 30 characters");
        }
    }

    /**
     * Displays the full details of the author, including name, birth date, death date (if applicable),
     * and genre. Calls the display method from the Person class and appends the genre.
     *
     * @return a string representation of the author's details.
     */
    @Override
    public String display() {

        String details = super.display();

        return details +
                "Genre: " +
                genre +
                "\n";
    }

    /**
     * Displays the reversed version of the author's full name and genre.
     * Calls the displayReversed method from the Person class and appends the genre.
     *
     * @return a string representation of the reversed name and genre.
     */
    @Override
    public String displayReversed() {

        String details = super.displayReversed();

        return details + "Genre: " +
                genre +
                "\n";
    }

    /**
     * Compares this author to another person based on their date of birth.
     * If the birth years are the same, compares by genre.
     *
     * @param other the other person to compare.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
     * or greater than the specified object.
     */
    @Override
    public int compareTo(Person other) {

        if(other == null) {
            throw new NullPointerException("Cannot compare to a null Person");
        }

        int dateComparison = super.compareTo(other); // Compare based on date of birth first

        if(dateComparison == 0 && other instanceof Author otherAuthor) {
            return this.genre.compareTo(otherAuthor.genre); // Compare by genre if birth dates are equal
        }

        return dateComparison;
    }

    /**
     * Gets the author's date of birth using the Person class.
     *
     * @return the date of birth of the author.
     */
    @Override
    public Date getDateOfBirth() {
        return super.getDateOfBirth();
    }

    /**
     * Gets the author's date of death using the Person class.
     *
     * @return the date of death of the author, or null if the author is still alive.
     */
    @Override
    public Date getDateOfDeath() {
        return super.getDateOfDeath();
    }

    /**
     * Gets the author's name using the Person class.
     *
     * @return the name of the author.
     */
    @Override
    public Name getName() {
        return super.getName();
    }

}
