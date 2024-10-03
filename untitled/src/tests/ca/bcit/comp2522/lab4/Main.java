package ca.bcit.comp2522.lab4;

/**
 * Main class to test all the functionalities .
 *
 * @author Farzad Farzin
 * @author Anil Bronson
 * @author Dalraj Bains
 * @author Arsh Mann
 * @version 1.0
 */
public class Main {

    /**
     * Main method to test the classes and implemented interfaces.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        //initializing authors
        final Author author1;
        final Author author2;
        final Author author3;
        final Author author4;
        final Author author5;

        //giving them values
        author1 = new Author(new Date(1975, 3, 10), null, new Name("John", "Smith"), "Fiction");
        author2 = new Author(new Date(1965, 6, 22), null, new Name("Jane", "Doe"), "Science");
        author3 = new Author(new Date(1980, 9, 15), null, new Name("Michael", "Brown"), "History");
        author4 = new Author(new Date(1955, 11, 30), null, new Name("Laura", "White"), "Biography");
        author5 = new Author(new Date(1990, 4, 18), null, new Name("Alice", "Green"), "Adventure");

        //initializing books
        final Book book1;
        final Book book2;
        final Book book3;
        final Book book4;
        final Book book5;

        //giving them values
        book1 = new Book("The Unknown World", new Date(2001, 5, 20), author1);
        book2 = new Book("Science of the Future", new Date(1999, 8, 13), author2);
        book3 = new Book("History of Time", new Date(2015, 11, 2), author3);
        book4 = new Book("Life Stories", new Date(1985, 3, 17), author4);
        book5 = new Book("Journey into Adventure", new Date(2020, 7, 25), author5);

        //Create Five person
        final Person person1;
        final Person person2;
        final Person person3;
        final Person person4;
        final Person person5;

        //giving them values
        person1 = new Person(new Date(1879, 3, 14), new Date(1955, 4, 18), new Name("Albert", "Einstein"));
        person2 = new Person(new Date(1867, 11, 7), new Date(1934, 7, 4), new Name("Marie", "Curie"));
        person3 = new Person(new Date(1869, 10, 2), new Date(1948, 1, 30), new Name("Mahatma", "Gandhi"));
        person4 = new Person(new Date(1809, 2, 12), new Date(1882, 4, 19), new Name("Charles", "Darwin"));
        person5 = new Person(new Date(1856, 5, 6), new Date(1939, 9, 23), new Name("Sigmund", "Freud"));

        //Create Five Biography of the created people
        final Biography bio1;
        final Biography bio2;
        final Biography bio3;
        final Biography bio4;
        final Biography bio5;

        bio1 = new Biography("Albert Einstein: A Life", new Date(2005, 1, 1), author1, person1);
        bio2 = new Biography("Marie Curie: Pioneer of Science", new Date(2010, 9, 10), author2, person2);
        bio3 = new Biography("Mahatma Gandhi: A Legacy", new Date(2018, 5, 15), author3, person3);
        bio4 = new Biography("Charles Darwin: Evolutionary Thinker", new Date(2000, 11, 12), author5, person4);
        bio5 = new Biography("Sigmund Freud: The Mind Unveiled", new Date(1998, 4, 25), author4, person5);

        //Create Five Autobiographies
        final Autobiography auto1;
        final Autobiography auto2;
        final Autobiography auto3;
        final Autobiography auto4;
        final Autobiography auto5;

        auto1 = new Autobiography("My Story: John Smith", new Date(2015, 4, 2), author1);
        auto2 = new Autobiography("Life of Jane Doe", new Date(2017, 2, 28), author2);
        auto3 = new Autobiography("Memoirs of Michael Brown", new Date(2021, 8, 30), author3);
        auto4 = new Autobiography("Journey of Laura White", new Date(1999, 10, 16), author4);
        auto5 = new Autobiography("Alice Green: The Adventurer", new Date(2022, 12, 9), author5);

        //Comparisons & Printing

        // Compare Books by Year Published
        System.out.println("Comparing Books by Year Published:");
        System.out.println("book1 vs book2: " + book1.compareTo(book2));
        System.out.println("book3 vs book5: " + book3.compareTo(book5));
        System.out.println();

        // Compare Authors by Birthdate
        System.out.println("Comparing Authors by Birthdate:");
        System.out.println("author1 vs author2: " + author1.compareTo(author2));
        System.out.println("author4 vs author5: " + author4.compareTo(author5));
        System.out.println();

        // Compare Biographies by Subject (Person)
        System.out.println("Comparing Biographies by Subject:");
        System.out.println("bio1 vs bio2: " + bio1.compareTo(bio2));
        System.out.println("bio3 vs bio4: " + bio3.compareTo(bio4));
        System.out.println();

        // Use Printable Interface to Print Details
        System.out.println("Printing Details Using Printable Interface:");
        System.out.println(book1.display());
        System.out.println(bio2.display());
        System.out.println(auto3.display());
        System.out.println();

        // Use Reversible Interface to Print Titles and Author Names Backward
        System.out.println("Printing Titles and Names in Reverse:");
        System.out.println(book1.displayReversed());
        System.out.println(author1.displayReversed());
        System.out.println(bio4.displayReversed());
    }
}
