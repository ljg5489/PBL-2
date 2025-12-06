import java.util.*;
/**
 * LoanDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LoanDB
{
    private LinkedList<Loan> loan;
    public LoanDB(){
        this.loan = new LinkedList<Loan>();
    }
    public void deleteOneLoan(Loan l){
        loan.remove(l);
    }
    public void addOneLoan(Loan l){
        loan.add(l);
    }
}