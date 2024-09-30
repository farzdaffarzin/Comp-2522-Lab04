package ca.bcit.comp2522.lab4;

public class Author extends Person implements Printable{

    private final String genre;

    /**
     * constructions of this class, validating and initiating the values to the person.
     *
     * @param dateOfBirth the birthdate.
     * @param dateOfDeath the death date.
     * @param name        the name
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
     * Validates if the genre is null or greater than 30 characters
     * @param genre of author
     */
    private void validate(final String genre) {

        if(genre == null){
            throw new NullPointerException("genre is null");
        }
        if(genre.length() > 30){
            throw new IllegalArgumentException("genre must be less than 30 characters");
        }
    }

    /**
     * Prints all attributes
     *
     * @return full information about the author
     */
    @Override
    public String display() {
        String details = super.display();
        return details + "Genre: " + genre + "\n";
    }

    /**
     * Reverse the full name
     *
     * @return reversed version of the author
     */
    @Override
    public String displayReversed(){
        String details = super.displayReversed();
        return details + "Genre: " + genre + "\n";
    }


    /**
     * Compares the authors based first on the superclass Person, which
     * compares DOB. After compares them based on genre.
     *
     * @param other the object to be compared.
     * @return comparison
     */
    @Override
    public int compareTo(Person other) {
        // First compare by date of birth (age)
        int dateComparison = super.compareTo(other); // Use the Person's compareTo method

        // If the authors have the same birth year, compare by genre
        if (dateComparison == 0 && other instanceof Author otherAuthor) {
            return this.genre.compareTo(otherAuthor.genre);
        }

        return dateComparison;
    }

    /**
     * getter for the date of birth to access it using superclass
     *
     * @return DOB of author
     */
    @Override
    public Date getDateOfBirth() {
        return super.getDateOfBirth();
    }


    /**
     * getter for the date of death to access it using superclass
     *
     * @return DOD of author
     */
    @Override
    public Date getDateOfDeath() {
        return super.getDateOfDeath();
    }


    /**
     * getter for the name to access it using superclass
     *
     * @return name of author
     */
    @Override
    public Name getName() {
        return super.getName();
    }




}


