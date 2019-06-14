public class Kindle {
//--------------------------------------------------------------------
private int totalPages;
private int currentPage;
//--------------------------------------------------------------------
public Kindle(int totalPages) {

this.totalPages = totalPages;

currentPage = 1;

}

public int turnPage(){

currentPage++;

return (currentPage);

}


public void display(String sentence){

System.out.println ("You are on page " + currentPage + " of "+ totalPages);

}




}




