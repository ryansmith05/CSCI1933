import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String filename) {
        Scanner s = null;
        try{
            s = new Scanner(new File(filename));
        }catch(Exception e){
            System.out.println("File not found");return null;
        }
        Bookshelf bookshelf = new Bookshelf(20);
        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] lines = line.split(",");
            bookshelf.add(new Book(lines[0], lines[1],Double.parseDouble(lines[2])));
        }return bookshelf;
    }
    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p;
        try {
            p = new PrintWriter(new File(fileName));
            p.write(b.toString());
            p.close();
        } catch (Exception e) {
            System.out.println("Error writing bookshelf to file: " + fileName);
        }
    }

}
