public class Bookshelf {
    private Book[] books;
    private int nextEmpty;

    public Bookshelf() {
        books = new Book[20];
        nextEmpty = 0;
    }
    public Bookshelf(int size) {
        books = new Book[size];
        nextEmpty = 0;
    }
    public Bookshelf(Book[] books) {
        this.books = books;
        nextEmpty = books.length;
    }
    public boolean add(Book newBook) {
        if(nextEmpty >= books.length) {
            return false;
        }
        books[nextEmpty++] = newBook;
        return true;
    }
    public Bookshelf getBooksByAuthor(String author) {
        Bookshelf booksByAuthor = new Bookshelf(books.length);

        for(int i=0;i<nextEmpty;i++) {
            if(author.equalsIgnoreCase(books[i].getAuthor())) {
                if(booksByAuthor.add(books[i])) {
                }
                else break;
            }
        }
        return booksByAuthor;
    }
    public String toString() {
        String result = new String();
        for(int i=0;i<nextEmpty;i++) {
            result += books[i] + "\n";
        }
        return result;
    }
    public void sort(char sortBy) {
        for (int i = 0; i < nextEmpty-1; i++)
            for (int j = 0; j < nextEmpty-i-1; j++)
                if (books[j].compareTo(books[j+1], sortBy) > 0){
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
    }
}
