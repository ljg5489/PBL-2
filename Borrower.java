import java.util.*;
/**
 * Borrower 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Borrower
{
    ArrayList<Loan> borrowInfo = new ArrayList<Loan>(10);
    String name;
    int borrowerID;
    /**
     * Borrower 클래스의 객체 생성자
     */
    public Borrower(String name)
    {
        this.name = name;
        this.borrowInfo = new ArrayList<Loan>(10);
    }

    /**
     * 
     *
     * 
     * 
     */
    public boolean check()
    {
        return this.borrowInfo.size() < 10 ;
    }
    
}