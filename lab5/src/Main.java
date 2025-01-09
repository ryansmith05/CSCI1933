public class Main {
    public static void main(String[] args) {
//// Milestone 1
//        // Given test
//        Bookshelf bs = new Bookshelf(5);
//        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
//        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
//        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
//        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
//        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
//        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
//        System.out.println(goodbooks);
//        //The expected output is:
//        //Eragon, Christopher Paolini, 10.0
//        //Eldest, Christopher Paolini, 10.0
//        //Brisingr, Christopher Paolini, 10.0
//        //Inheritance, Christopher Paolini, 10.0
//
//        // Test Case 1: adding a book to an empty bookshelf and printing the bookshelf
//        Bookshelf bs1 = new Bookshelf();
//        bs1.add(new Book("The Hunger Games", "Suzanne Collins", 1.0));
//        System.out.println(bs1);
//        //Expected output;
//        //The Hunger Games, Suzanne Collins, 1.0
//
//        // Test Case 2: getting books by a specific author, and printing the new Bookshelf
//        Bookshelf bs2 = new Bookshelf(5);
//        bs2.add(new Book("CSCI 1933", "Ryan Smith", 1.0));
//        bs2.add(new Book("CSCI 2011", "Ryan Smith",1.5));
//        bs2.add(new Book("MATH 1271", "Bob Lee", 2.0));
//        bs2.add(new Book("MATH 1272", "Chris Dovolis", 3.0));
//        bs2.add(new Book("CSCI 1133", "Alan Scott", 4.0));
//        Bookshelf authorBooks = bs2.getBooksByAuthor("Ryan Smith");
//        System.out.println(authorBooks);
//        //Expected output:
//        //CSCI 1933, Ryan Smith, 1.0
//        //CSCI 2011, Ryan Smith, 1.5

//// Milestone 2
//        // Given test
//        Bookshelf bs = new Bookshelf(5);
//        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
//        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
//        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
//        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
//        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
//        bs.sort('a');
//        System.out.println(bs);
//        // The expected output is:
//        // Dracula, Bram Stoker, 7.5
//        // Eragon, Christopher Paolini, 10.0
//        // The Fellowship of the Ring, J.R.R. Tolkein, 10.0
//        // The Diary of a Wimpy Kid, Jeff Kinney, 0.0
//        // Twilight, Stephenie Meyer, 0.0
//
//        // Test 2: Sort books by title in alphabetical order
//        Bookshelf bs1 = new Bookshelf(5);
//        bs1.add(new Book("Eldest", "Christopher Paolini", 10.0));
//        bs1.add(new Book("Eragon", "Christopher Paolini", 10.0));
//        bs1.add(new Book("Brisingr", "Christopher Paolini", 10.0));
//        bs1.add(new Book("Inheritance", "Christopher Paolini", 10.0));
//        bs1.add(new Book("Dracula", "Bram Stoker", 7.5));
//        bs1.sort('t');
//        System.out.println(bs1);
//        // Expected output:
//        // Brisingr, Christopher Paolini, 10.0
//        // Dracula, Bram Stoker, 7.5
//        // Eldest, Christopher Paolini, 10.0
//        // Eragon, Christopher Paolini, 10.0
//        // Inheritance, Christopher Paolini, 10.0
//
//        // Test 2: Sort books by rating in descending order
//        Bookshelf bs2 = new Bookshelf(3);
//        bs2.add(new Book("Eragon", "Christopher Paolini", 9.0));
//        bs2.add(new Book("Dracula", "Bram Stoker", 7.5));
//        bs2.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
//        bs2.sort('r');
//        System.out.println(bs2);
//        // Expected output:
//        // The Fellowship of the Ring, J.R.R. Tolkein, 10.0
//        // Eragon, Christopher Paolini, 9.0
//        // Dracula, Bram Stoker, 7.5

//// Milestone 3
//        Bookshelf myShelf = BookshelfReader.readBooksFromFile("bookinput.txt");
//        myShelf.sort('r');
//        BookshelfReader.writeShelfToFile(myShelf, "output.txt");


//// Milestone 4
//        int[][] tempMat = {{1,2,3},{4,5,6},{7,8,9}};
//        Matrix m = new Matrix(tempMat);
//        System.out.println("Original Matrix");
//        System.out.println(m.toString());
//        m = m.transpose();
//        System.out.println("Matrix after Transpose");
//        System.out.println(m.toString());
    }
}