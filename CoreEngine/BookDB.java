package CoreEngine;
import java.util.*;
/**
 * BookDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BookDB
{
    TreeSet<Book> book;
    private Iterator<Book> iterator = null;
    public BookDB(){
        this.book = new TreeSet<Book>();
    }
    public Book searchOneBook(int bookID){
        for(Book b : book){ 
            if(b.bookID == bookID){
                return b;
            }
        } 
        return null;
    }
    public void saveOneBook(Book b){
        book.add(b);
    }
    public Book takeOneBook() {
        if (iterator == null) {
            iterator = book.iterator();
        }
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            iterator = null; 
            return null;
        }
    }
    public boolean checkSameName(String title){
        for(Book b : book){
            if(b.title.equals(title)){
                return true;
            }
        }
        return false;
    }
}