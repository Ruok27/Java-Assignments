import java.util.Scanner;
//=============================================================================
public class UseKindle {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

        Kindle aBook;
        int numberOfPages;

//----Get person information
        System.out.p1rint("How many pages in the book : ");
        numberOfPages = keyboard.nextInt();

//----Create object
        aBook = new Kindle(numberOfPages);
        aBook.display("Initially");

//----Do some reading
        aBook.turnPage();
        aBook.turnPage();
        aBook.turnPage();
        aBook.turnPage();
        aBook.display("A bit later");
    }
//-----------------------------------------------------------------------------
}
//=============================================================================

