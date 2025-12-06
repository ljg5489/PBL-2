
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
    public LibraryApplication(){
        
    }
    public void registerOneBorrower(String name){
        int borrowerID = borrowerDB.checkSameName(name);
        Borrower borrower = new Borrower(name, borrowerID);
        borrowerDB.saveOneBorrower(borrower);
        System.out.println("이용자 등록 완료 : " + name +" 번호 : " + borrowerID);
    }
    public void registerOneBook(String title, String author, int bookID){
        if (title == null || author == null) {
            System.out.println("오류: 필수 입력 요소를 입력하세요");
            return;
        }
        Book book = new Book(title, author, bookID);
        bookDB.saveOneBook(book);
        System.out.println("책 등록 완료 :" + book);
    }
    public void displayBooksForLoan(){
        System.out.println("----- 대출 가능 도서 목록 -----");
        for(;; ){
            b = BookDB.takeOneBook();
            if(b.check()== true){
                b.displayOneBook();
            }
        }
        if(){
            System.out.println("대출 가능한 도서가 없습니다");
        }
    }
    public void displayBooksOnLoan(){
        System.out.println("----- 대출 중인 도서 목록 -----");
        for(;;){
            b = bookDB.takeOneBOok();
            if(b.check() == false){
                b.displayOneBook();
            }
        }
        if(){
            System.out.println("대출 중인 도서가 없습니다");
        
        }
    }
    public void borrowOneBook(String name, int bookID){
        Borrower borrower= borrowerDB.searchOneBorrower(name, borrowerID);
        if (borrower.check() == false) {
            System.out.println("대출 한도 초과이거나 대출 불가 이용자입니다.");
            return;
        }
        Book book = bookDB.searchOneBook(bookID);
        if (b.check() == false) {
            System.out.println("이미 대출 중인 책입니다.");
            return;
        }
        Loan loan =new Loan(borrower, book);
        loanDB.addOneLoan(loan);
        borrower.borrowerInfo.add(loan);
        book.borrowList = loan;
        System.out.println("대출 성공: " + borrower.name + "->" + book);
    }
    public void returnOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name, borrowerID);
        Book book = bookDB.searchOneBook(bookID);
        borrower.borrowInfo.remove(loan);
        book.borrowList = null;
        loanDB.deleteOneLoan(loan);
        System.out.println("반납 성공: " + borrower.name + "->" + book);
    }
}