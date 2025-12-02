import java.util.*;
/**
 * BookDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BookDB
{
    TreeSet<Book> bookList;
    public BookDB(){
        this.bookList = new TreeSet<Book>();
    }
    public Book searchOneBook(int bookID){
        for(Book b : bookList){
            if(b.bookID == bookID){
                return b;
            }
        }
        return null;
    }
    public void saveOneBook(Book b){
        bookList.add(b);
    }
    public Book takeOneBook(){
        
    }
}