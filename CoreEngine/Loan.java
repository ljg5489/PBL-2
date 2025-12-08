package CoreEngine;


import java.util.Date;
import java.util.Calendar;
/** 
 * Loan 클래스의 설명을 작성하세요.
 * 대출 객체를 생성하는 클래스
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.8)
 */
public class Loan
{
    private Borrower borrower;
    private Book borrowedBook;   
    protected Date borrowDate;
    protected Date returnDate;
    protected Date actualReturnDate;
    /**
     *  Loan 클래스의 객체 생성자. 속성 초기화 및 대출일, 반납일 설정
     * 
     */
    public Loan(Borrower borrower, Book book){
        this.borrower = borrower;
        this.borrowedBook = book;
        this.borrowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DATE,10);
        this.returnDate = calendar.getTime();
        
        borrower.borrowInfo.add(this);
        book.borrowList = this;
    }
}