import java.util.*;
/**
 * LoanDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LoanDB
{
    private LinkedList<Loan> loanList;
    public LoanDB(){
        this.loanList = new LinkedList<Loan>();
    }
    public void deleteOneLoan(Loan l){
        loanList.add(l);
    }
    public void addOneLoan(Loan l){
        loanList.remove(l);
    }
}