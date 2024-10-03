package ca.bcit.comp2522.lab4;

/**
 * Person class is able to display the name of the user, reverse it and show the reverse,
 * and also compare their age and put older people on top.
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 *
 * @version 1.0
 */
public class Person implements Printable, Comparable<Person>, Reversible {
  private final Date dateOfBirth;
  private final Date dateOfDeath; // Nullable
  private final Name name;

  /**
   * constructions of this class, validating and initiating the values to the person.
   *
   * @param dateOfBirth the birthdate.
   * @param dateOfDeath the death date.
   * @param name the name
   */
  public Person(final Date dateOfBirth,
                final Date dateOfDeath,
                final Name name) {

    validator(dateOfBirth, name);

    this.dateOfBirth = dateOfBirth;
    this.dateOfDeath = dateOfDeath;
    this.name = name;
  }

  /**
   * validating all the inputs are not null
   * @param dateOfBirth the birthdate
   * @param name the name
   */
  private void validator(final Date dateOfBirth,
                         final Name name) {

    if (dateOfBirth == null || name == null) {
      throw new NullPointerException("dateOfBirth and name cannot be null");
    }
  }

  /**
   * Print all attributes
   *
   * @return full displayed information of the person
   */
  @Override
  public String display () {
    StringBuilder displayName = new StringBuilder();

    displayName.append("Name: ").append(name.display()).append("\n");
    displayName.append("Date of Birth: ").append(dateOfBirth.getYYYYMMDD()).append("\n");

    if(dateOfDeath != null)
    {
      displayName.append("Date of Death: ").append(dateOfDeath.getYYYYMMDD()).append("\n");
    }
    else
    {
      displayName.append("Date of Death: Still alive\n");
    }
    return displayName.toString();
  }

  /**
   * Reverse the full name
   *
   * @return reversed version of the full name
   */
  @Override
  public String displayReversed() {
    String fullName = name.getFirstName() + " " + name.getLastName();

    return new StringBuilder(fullName).reverse().toString();
  }

  /**
   * compares the age of the people.
   *
   * @param other the object to be compared.
   * @return the larger the number the older the people.
   */
  @Override
  public int compareTo(final Person other) {
    return this.dateOfBirth.getYear() - other.dateOfBirth.getYear();
  }

  /**
   * getter for the date of birth to access it
   * @return date of birth
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * getter for the date of death to access it
   * @return date of death
   */
  public Date getDateOfDeath() {
    return dateOfDeath;
  }

  /**
   * getter for the name to access it
   * @return name
   */
  public Name getName() {
    return name;
  }
}
