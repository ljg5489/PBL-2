package CoreEngine;
import java.util.*;

/**
 * LibraryApplication 클래스
 * 이용자 등록, 책 등록, 대출 가능한 책 표시, 대출 중인 책 표시, 대출, 반납의 기능을 수행하는 
 * 클래스
 * 
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.2)
 */
public class LibraryApplication
{
    private String name;
    private BookDB bookDB;
    private BorrowerDB borrowerDB;
    private LoanDB loanDB;
    /**
     * LibraryApplication 클래스의 객체 생성자. 
     * 각 객체의 DB를 생성, 해당 어플리케이션의 이름을 초기화.
     * 
     */
    public LibraryApplication(String name){
        this.name = name;
        bookDB = new BookDB();
        borrowerDB = new BorrowerDB();
        loanDB = new LoanDB();
    }
    /**
     * 새로운 이용자를 등록하는 메소드
     *
     * @param 등록하려는 이용자의 이름
     * @return 같은 이름의 이용자가 있다면 오류메시지, 아니라면 등록 완료 메시지 리턴
     */
    public String registerOneBorrower(String name){
        boolean result = borrowerDB.checkSameName(name);
        if (result == true){
            return "이미 등록된 이름 " + name + " 이(가) 있습니다.";
        } 
        else{
            Borrower borrower = new Borrower(name);
            borrowerDB.saveOneBorrower(borrower);
            return "이용자 등록 완료 : ";
        }   
    }
    /**
     * 새로운 책을 등록하는 메소드
     *
     * @param  등록하려는 책의 제목, 저자, 고유번호
     * @return 같은 이름의 책이 있다면 오류메시지, 아니라면 등록 완료 메시지 리턴
     */
    public String registerOneBook(String title, String author, int bookID){
        boolean result = bookDB.checkSameName(title);
        if (result == true ) {
            return "이미 등록된 책 " + title + " 이(가) 있습니다.";
        }
        else{
            Book book = new Book(title, author, bookID);
            bookDB.saveOneBook(book);
            return "책 등록 완료 :";
        }
    }
    /**
     * 대출 가능한 책을 표시하는 메소드
     *
     * @param 
     * @return 대출 가능한 책의 정보 리턴
     */
    public String displayBooksForLoan(){
        StringBuilder sb = new StringBuilder();
        sb.append("----- 대출 가능 도서 목록 -----\n");
        Book b;
        while((b = bookDB.takeOneBook()) != null){
            if(b.check() == true){
                sb.append(b.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    /**
     * 대출 중인 책을 표시하는 메소드
     *
     * @param 
     * @return 대출 중인 책의 정보 리턴
     */
    public String displayBooksOnLoan(){
        StringBuilder sb = new StringBuilder();
        sb.append("----- 대출 중인 도서 목록 -----\n");
        Book b;
        while((b = bookDB.takeOneBook()) != null){
            if(b.check() == false){
                sb.append(b.toString()).append("\n");
            }
        }
        return sb.toString();
    }
    /**
     * 대출을 진행하는 메소드. 
     * 이용자와 책이 등록되어있는지, 대출 한도를 넘지 않고 연체 패널티가 없는 이용자인지,
     * 대출 중이지 않은 책인지 확인 후에 대출 진행
     *
     * @param 대출을 진행하려는 이용자의 이름과 책의 고유번호
     * @return 대출이 불가능하다면 오류메시지, 대출이 가능하면 대출 완료 메시지 리턴
     */
    public String loanOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name);
        
        if (borrower == null) {
            return "등록되지 않은 이용자입니다: " + name;
        }
        if (borrower.check() == false) {
            return "대출 한도를 초과한 이용자입니다.";
        }
        if(borrower.checkOverdueBook() == false){
            return "연체로 인해 대출이 불가능한 이용자입니다.";
        }
        Book book = bookDB.searchOneBook(bookID);
        
        if (book == null) {
            return "등록되지 않은 책입니다.";
        }
        if (book.check() == false) {
            return "이미 대출 중인 책입니다.";
        }
        
        Loan loan = new Loan(borrower, book);
        loanDB.addOneLoan(loan);
        
        return "대출이 완료되었습니다. \n" + borrower + "\n" + book;
    }
    /**
     * 반납을 진행하는 메소드.
     * 이용자와 책이 등록되어 있는지, 반납 가능한 책인지 확인 후 반납 과정 진행 및 
     * 반납일을 지났다면 연체 패널티를 부과함
     *
     * @param 반납을 진행하려는 이용자의 이름과 책의 고유번호
     * @return 반납이 불가능하다면 오류메시지, 반납이 가능하면 반납 완료 메시지 리턴
     */
    public String returnOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name);
        Book book = bookDB.searchOneBook(bookID);
        
        if (borrower == null){ 
            return "등록되지 않은 이용자입니다." + name;
        }
        if (book == null){
            return "등록되지 않은 책입니다.";   
        }

        if(book.check() == false){
            Loan loan = book.borrowList;
            
            borrower.borrowInfo.remove(loan);
            book.borrowList = null;
            loan.actualReturnDate = new Date();
            loanDB.deleteOneLoan(loan);
             if(loan.actualReturnDate.after(loan.returnDate)){
                long diff = loan.actualReturnDate.getTime() - loan.returnDate.getTime();
                long overDueDate = diff/ (1000 * 60 * 60 * 24);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(loan.actualReturnDate); 
                calendar.add(Calendar.DATE, (int)overDueDate); 
                borrower.penaltyEndDate = calendar.getTime();
            }
            return "반납이 완료되었습니다. \n"+ borrower+ "\n" + book;
        }
        else{
            return "대출 중인 책이 아닙니다.";
        }
    }
}