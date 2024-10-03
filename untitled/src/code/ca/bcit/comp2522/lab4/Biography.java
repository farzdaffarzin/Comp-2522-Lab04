package ca.bcit.comp2522.lab4;

/**
 * Biography class represents a type of book about a person's life.
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 *
 * @version 1.0
 */
public class Biography extends Book implements Printable {
  private final Person subject;

  /**
   * Constructs a new Biography instance with the specified title, year of publication, author, and subject.
   *
   * @param title The title of the book. Must not be null, blank, or more than 100 characters.
   * @param yearPublished The year the book was published, represented as a Date object. Must not be null.
   * @param author The author of the book. Must not be null.
   * @param subject The subject of the biography. Must not be null.
   * @throws IllegalArgumentException if any of the parameters are invalid or null.
   */
  public Biography(final String title,
                   final Date yearPublished,
                   final Author author,
                   final Person subject) {

    super(title, yearPublished, author);  // Calls the constructor of Book
    if (subject == null) {
      throw new IllegalArgumentException("Subject cannot be null");
    }
    this.subject = subject;
  }

  /**
   * Overrides the equals method to compare two Biography objects.
   * Biographies are considered equal if they are about the same subject.
   *
   * @param obj The other object to compare to.
   * @return true if the biographies are about the same subject, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {

    // Same object
    if (this == obj) {
      return true;
    }

    // Different class
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    // Compare subjects
    Biography otherBiography = (Biography) obj;
    return this.subject.equals(otherBiography.subject);
  }

  /**
   * Displays the details of the biography, including the title, year published, author, and subject.
   *
   * @return A string containing the biography's title, year of publication, author, and subject details.
   */
  @Override
  public String display() {
    return super.display() +
            "Subject: " +
            subject.display();
  }
}
