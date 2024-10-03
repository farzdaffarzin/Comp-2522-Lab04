package ca.bcit.comp2522.lab4;

/**
 *  Autobiography class represents a special,
 *  type of Biography where the subject is the same as the author.
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 *
 * @version 1.0
 */
public class Autobiography  extends Biography implements Printable {

  /**
   * Constructs an Autobiography with the given title, publication year, and author.
   * The subject is automatically set to the author.
   *
   * @param title The title of the autobiography. Must not be null, blank, or more than 100 characters.
   * @param yearPublished The year the autobiography was published, represented as a {@link Date} object. Must not be null.
   * @param author The author of the autobiography, who is also the subject. Must not be null.
   * @throws IllegalArgumentException if any of the parameters are invalid or null.
   */
  public Autobiography(final String title,
                       final Date yearPublished,
                       final Author author) {

    super(title, yearPublished, author, author);
  }

  /**
   * Displays the details of the autobiography, including the title, year published, and author's information.
   *
   * @return A string containing the autobiography's title, year of publication, and author details.
   */
  @Override
  public String display() {

    return super.display();
  }
}
