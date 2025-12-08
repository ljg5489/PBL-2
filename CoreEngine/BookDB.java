package CoreEngine;
import java.util.*;
/**
 * Book 객체를 저장할 수 있는 DB역할을 하는 클래스
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.08)
 */
public class BookDB
{
    protected TreeSet<Book> book;
    protected Iterator<Book> iterator = null;
    /**
     *  BookDB의 생성자
     *
     * 
     * 
     */
    public BookDB(){
        this.book = new TreeSet<Book>();
    }

    /**
     * bookID가 일치하는 Book 객체를 찾는 메소드
     *
     * @param  찾을 Book 객체의 bookID
     * @return    bookID가 일치하는 Book 객체
     */
    public Book searchOneBook(int bookID){
        for(Book b : book){ 
            if(b.bookID == bookID){
                return b;
            }
        } 
        return null;
    }
    
    /**
     * Book 객체를 저장하는 메소드
     *
     * @param  저장할 Book 객체
     *
     */
    public void saveOneBook(Book b){
        book.add(b);
    }
    
    /**
     * DB 안의 Book 객체 하나를 반환하는 메소드 
     *
     * 
     * @return   다음 위치의 Book 객체
     */
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
    
    /**
     * 같은 제목의 Book객체가 존재하는지 확인하는 메소드
     *
     * @param  비교할 Book 객체의 title
     * @return    Book 객체들의 title 비교 후 같다면 true, 없다면 false 리턴
     */
    public boolean checkSameName(String title){
        for(Book b : book){
            if(b.title.equals(title)){
                return true;
            }
        }
        return false;
    }
    
}