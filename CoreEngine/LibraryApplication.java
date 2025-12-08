package CoreEngine;
import java.util.Date;

/**
 * LibraryApplication 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryApplication
{
    private String name;
    private BookDB bookDB;
    private BorrowerDB borrowerDB;
    private LoanDB loanDB;
    public LibraryApplication(String name){
        this.name = name;
        bookDB = new BookDB();
        borrowerDB = new BorrowerDB();
        loanDB = new LoanDB();
    }
    public void registerOneBorrower(String name){
        boolean result = borrowerDB.checkSameName(name);
        if (result == true){
            System.out.println("이미 등록된 이름 " + name + " 이(가) 있습니다.");
        } 
        else{Borrower borrower = new Borrower(name);
            borrowerDB.saveOneBorrower(borrower);
            System.out.println("이용자 등록 완료 : " + name);
        }   
    }
    public void registerOneBook(String title, String author, int bookID){
        boolean result = bookDB.checkSameName(title);
        if (result == true ) {
            System.out.println("이미 등록된 책 " + title + " 이(가) 있습니다.");
        }
        else{Book book = new Book(title, author, bookID);
            bookDB.saveOneBook(book);
            System.out.println("책 등록 완료 :" + book);
        }
    }
    public void displayBooksForLoan(){
        System.out.println("----- 대출 가능 도서 목록 -----");
        Book b;
        while((b = bookDB.takeOneBook()) != null){
            if(b.check()== true){
                b.displayOneBook();
            }
        }
    }
    public void displayBooksOnLoan(){
        System.out.println("----- 대출 중인 도서 목록 -----");
        Book b;
        while((b = bookDB.takeOneBook()) != null){
            if(b.check()== false){
                b.displayOneBook();
            }
        }
    }
    public void borrowOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name);
        if (borrower.check() == false) {
            System.out.println("대출 한도 초과이거나 대출 불가 이용자입니다.");
            return;
        }
        //if(borrower == null){
            // System.out.println("등록되지 않은 이용자입니다:" + name);
            // return;
        // }
        Book book = bookDB.searchOneBook(bookID);
        if (book.check() == false) {
            System.out.println("이미 대출 중인 책입니다.");
            return;
        }
        // if(book == null){
            // System.out.println("등록되지 않은 책입니다: ID" + bookID);
            // return;
        // }
        Loan loan =new Loan(borrower, book);
        loanDB.addOneLoan(loan);
        borrower.borrowInfo.add(loan);
        book.borrowList = loan;
        System.out.println("대출 성공: " + borrower.name + "->" + book);
    }
    public void returnOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name);
        Book book = bookDB.searchOneBook(bookID);
        if(book.check()== false){
            Loan loan = book.borrowList;
            borrower.borrowInfo.remove(loan);
            book.borrowList = null;
            loan.actualReturnDate = new Date();
            loanDB.deleteOneLoan(loan);
            // if(loan.actualReturnDate.after(loan.returnDate)){
                
            // }
            System.out.println("반납 성공: " + borrower.name + "->" + book);
        }
        else{
            System.out.println("대출 중인 책이 아닙니다.");
        }
        
    }
}
