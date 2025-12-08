
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
        bookDB = new BookDB();
        borrowerDB = new BorrowerDB();
        loanDB = new LoanDB();
    }

    //UC1 이용자 1명 등록
    public void registerOneBorrower(String name){
        boolean exists = borrowerDB.checkSameName(name);

        if (exists) {
            System.out.println("이미 등록된 이름이 있습니다 (등록불가)");
            return;
        }
        Borrower u = new Borrower(name);
        borrowerDB.saveOneBorrower(u);
        System.out.println("이용자 등록이 완료되었습니다.");
    }

    //UC2 책 1권 등록
    public void registerOneBook(String title, String author, int bookID){
        if (title == null || author == null) {
            System.out.println("오류: 필수 입력 요소를 입력하세요");
            return;
        }

        Book book = new Book(title, author, bookID);
        bookDB.saveOneBook(book);

        System.out.println("책 등록 완료 :" + book);
    }

    //UC3 대출 가능한 책 화면에 출력 
    public void displayBooksForLoan(){
        System.out.println("----- 대출 가능 도서 목록 -----");
        for(;;){
            Book b = bookDB.takeOneBook();
            if(b.check()== true){
                b.displayOneBook();
                exist = true;
            }
        }
        if(b== null){
            System.out.println("대출 가능한 도서가 없습니다");
        }
    }

    //UC4 대출 중인 책 화면에 출력
    public void displayBooksOnLoan(){
        System.out.println("----- 대출 중인 도서 목록 -----");
        for(;;){
            b = bookDB.takeOneBOok();
            if(b.check() == false){
                b.displayOneBook();
                exist = true;
            }
        }
        if(b == null){
            System.out.println("대출 중인 도서가 없습니다");
        }
    }

    //UC5 책 1권 대출
    public void borrowOneBook(String name, int bookID){
        Borrower borrower= borrowerDB.searchOneBorrower(name);
        if (borrower == null) {
            System.out.println("해당 이용자를 찾을 수 없습니다.");
            return;
        }

        Book book = bookDB.searchOneBook(bookID);
        if (book == null) {
            System.out.println("해당 책을 찾지 못했습니다.");
            return;
        }

        if(book.check() == false){
            System.out.println("이 책은 현재 대출중입니다.");
            return;
        }

        Loan loan =new Loan(borrower, book);
        loanDB.addOneLoan(loan);
        borrower.borrowerInfo.add(loan);
        book.borrowList = loan;
        System.out.println("대출이 완료되었습니다.: " + borrower.name + "->" + book);
    }

    //UC#6 책 1권 반납
    public void returnOneBook(String name, int bookID){
        Borrower borrower = borrowerDB.searchOneBorrower(name);
        Book book = bookDB.searchOneBook(bookID);
        borrower.borrowInfo.remove(loan);
        borrower.borrowInfo.remove(loan);
        book.borrowList = null;
        loanDB.deleteOneLoan(loan);
        System.out.println("반납 성공: " + borrower.name + "->" + book);
    }

    //UC#7 연체의 경우
    public void overdueBookPenalty(String name){
        Borrower borrower = borrowerDB.searchOneBorrower(name);

        if (borrower == null) {
            System.out.println("해당 이용자를 찾을 수 없습니다.");
            return;
        }
    }
}