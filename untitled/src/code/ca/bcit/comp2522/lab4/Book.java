package ca.bcit.comp2522.lab4;

/**
 * The Book class represents a book with a title, publication year, and author.
 * It implements Comparable to compare books by their publication year,
 * Printable to display details, and Reversible to display the title in reverse.
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 *
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible{
  private final String title;
  private final Date yearPublished;
  private final Author  author;

  /**
   * Constructs a new Book instance with the specified title, year of publication, and author.
   *
   * @param title The title of the book. Must not be null, blank, or more than 100 characters.
   * @param yearPublished The year the book was published, represented as a Date object. Must not be null.
   * @param author The author of the book. Must not be null.
   * @throws IllegalArgumentException if the title is null, blank, or more than 100 characters, or if the yearPublished or author is null.
   */
  public Book(final String title,
              final Date yearPublished,
              final Author author) {
    //validators for the values
    validateTitle(title);
    validateYearPublished(yearPublished);
    if (author == null) {
      throw new IllegalArgumentException("Author cannot be null");
    }
    this.title = title;
    this.yearPublished = yearPublished;
    this.author = author;
  }

  /**
   * Validates the title of the book.
   *
   * @param title The title of the book.
   * @throws IllegalArgumentException if the title is null, blank, or more than 100 characters.
   */
  private void validateTitle(final String title) {
    if (title == null || title.isBlank() || title.length() > 100) {
      throw new IllegalArgumentException("Title must be non-null, non-blank, and less than 100 characters");
    }
  }

  /**
   * Validates the year of publication.
   *
   * @param yearPublished The year the book was published, represented as a Date object.
   * @throws IllegalArgumentException if yearPublished is null.
   */
  private void validateYearPublished(final Date yearPublished) {
    if (yearPublished == null) {
      throw new IllegalArgumentException("Year published cannot be null");
    }
  }

  /**
   * Displays the details of the book, including the title, year published, and author.
   *
   * @return A string containing the book's title, year of publication, and author details.
   */
  @Override
  public String display() {

    String display = "Title: " + title +
            "\nYear Published: " + yearPublished.getYear() + "-" +
            yearPublished.getMonth() + "-" + yearPublished.getDay() +
            "\nAuthor: " + author.display();
    return display;
  }

  /**
   * Displays the book's title in reverse.
   *
   * @return A string containing the reversed book title.
   */
  @Override
  public String displayReversed() {
    StringBuilder reversedTitle = new StringBuilder(title);
    return "Reversed Title: " + reversedTitle.reverse().toString();
  }

  /**
   * Compares this book with another book based on the year of publication.
   * Older books are considered "larger."
   *
   * @param other The other book to compare.
   * @return A negative integer, zero, or a positive integer as this book is older than, the same age as,
   *         or younger than the specified book.
   */
  @Override
  public int compareTo(Book other) {
    // First, compare by year
    if (this.yearPublished.getYear() != other.yearPublished.getYear()) {
      return Integer.compare(this.yearPublished.getYear(), other.yearPublished.getYear());
    }

    // If years are the same, compare by month
    if (this.yearPublished.getMonth() != other.yearPublished.getMonth()) {
      return Integer.compare(this.yearPublished.getMonth(), other.yearPublished.getMonth());
    }

    // If months are the same, compare by day
    return Integer.compare(this.yearPublished.getDay(), other.yearPublished.getDay());
  }

  /**
   * Gets the title of the book.
   *
   * @return The title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the year the book was published.
   *
   * @return The year the book was published, represented as a Date object.
   */
  public Date getYearPublished() {
    return yearPublished;
  }

  /**
   * Gets the author of the book.
   *
   * @return The author of the book.
   */
  public Author getAuthor() {
    return author;
  }

}
