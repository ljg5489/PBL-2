package CoreEngine;
import java.util.Date;

/**
 * LibraryApplication 클래스
 *
 * 
 *
 * 
 *
 * @author (2022320005 이진규, 2022320009 이상원)
 * @version (2025.12.2)
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
    
    public String registerOneBorrower(String name){
        boolean result = borrowerDB.checkSameName(name);
        if (result == true){
            return "이미 등록된 이름 " + name + " 이(가) 있습니다.";
        } 
        else{
            Borrower borrower = new Borrower(name);
            borrowerDB.saveOneBorrower(borrower);
            return "이용자 등록 완료 : " + name;
        }   
    }
    
    public String registerOneBook(String title, String author, int bookID){
        boolean result = bookDB.checkSameName(title);
        if (result == true ) {
            return "이미 등록된 책 " + title + " 이(가) 있습니다.";
        }
        else{
            Book book = new Book(title, author, bookID);
            bookDB.saveOneBook(book);
            return "책 등록 완료 :" + book;
        }
    }
    
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
    
    public String loanOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name);
        
        if (borrower == null) {
            return "등록되지 않은 이용자입니다: " + name;
        }
        if (borrower.check() == false) {
            return "대출 한도 초과이거나 대출 불가 이용자입니다.";
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
            
            return "반납이 완료되었습니다. \n"+ borrower+ "\n" + book;
        }
        else{
            return "대출 중인 책이 아닙니다.";
        }
    }
}