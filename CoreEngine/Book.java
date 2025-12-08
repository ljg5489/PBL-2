package CoreEngine;
/**
 * Book 클래스의 설명을 작성하세요.
 * 책 객체를 나타내는 클래스. Comparable 인터페이스를 상속한다.
 * 객체가 대출 가능한지 확인하는 역할을 함.
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.8)
 */
public class Book implements Comparable<Book>
{
    Loan borrowList;
    protected String title;
    protected String author; 
    protected int bookID;
    /**
     * Book 클래스의 객체 생성자. 미대출 상태로 설정, 속성 초기화 진행.
     *
     */
    public Book(String title, String author, int bookID)
    {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.borrowList = null;
    }
    /**
     * Book이 대출 중인지 확인하는 메소드
     *
     * @param  
     * @return 대출 중이 아니라면 true, 대출 중이라면 false 리턴
     */
    public boolean check(){
        if(this.borrowList == null){
        return true;
        }
        return false;
    }
    /**
     * 책의 정보를 화면에 표시하는 메소드
     *
     * @param  
     * @return 
     */
    public void displayOneBook(){
        System.out.println(this.toString());
    }
    /**
     * Object 클래스의 메소드 String toString() 오버라이딩
     *
     */
    public String toString(){
        return "제목 : " + title + "\n 저자 : " + author + "\n 책 고유번호 :" + bookID;
    }
    /**
     * TreeSet을 이용할 때 객체의 순서를 정리하도록 돕는 메소드
     *
     * @param 저장하려는 책 객체
     * @return 이진 트리의 계수를 결정한다.
     */
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