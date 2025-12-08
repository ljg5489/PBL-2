/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book implements Comparable<Book>
{
    Loan borrowList;
    String title;
    String author; 
    int bookID;
    /**
     * Book 클래스의 객체 생성자
     *
     */
    public Book(String title, String author, int bookID)
    {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.borrowList = null;
    }
    public boolean check(){
        if(this.borrowList == null){
        return true;
        }
        return false;
    }
    public void displayOneBook(){
        System.out.println(this.toString());
    }
    public String toString(){
        return "제목 : " + title + " 저자 : " + author + " 책 고유번호 :" + bookID;
    }
    public int compareTo(Book other) {
        if (this.bookID < other.bookID) {
            return -1;
        } 
        else if (this.bookID > other.bookID) {
            return 1;
        } 
        else {
            return 0;
        }
    }
}