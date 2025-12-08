package CoreEngine;


import java.util.*; 
/**
 * Loan 객체를 저장할 수 있는 DB역할을 하는 클래스 
 *
 * @author (2022320005 이진규)
 * @version (2025.12.08)
 */
public class LoanDB 
{
    private LinkedList<Loan> loan;
    /**
     * LoanDB의 생성자
     *
     * 
     * 
     */
    public LoanDB(){
        this.loan = new LinkedList<Loan>();
    }
    
    /**
     * Loan 객체를 LoanDB에서 삭제하는 메소드
     *
     * @param  삭제할 Loan 객체
     * @return   
     */
    public void deleteOneLoan(Loan l){
        loan.remove(l);
    }
    
    /**
     * Loan 객체를 저장하는 메소드
     *
     * @param  저장할 Loan 객체
     * @return   
     */
    public void addOneLoan(Loan l){
        loan.add(l);
    }
}