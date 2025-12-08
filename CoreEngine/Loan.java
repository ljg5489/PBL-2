package CoreEngine;


import java.util.Date;
import java.util.Calendar;
/** 
 * Loan 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Loan
{
    private Borrower borrower;
    private Book borrowedBook;   
    Date borrowDate;
    Date returnDate;
    Date actualReturnDate;
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