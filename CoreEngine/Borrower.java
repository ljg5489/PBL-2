package CoreEngine;


import java.util.*;
/**
 * Borrower 클래스의 설명을 작성하세요.
 * 이용자 객체를 나타내는 클래스. 객체가 대출가능한지 확인하는 역할을 함.
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금) 
 * @version (2025.12.8)
 */
public class Borrower
{
    ArrayList<Loan> borrowInfo = new ArrayList<Loan>(10);
    protected String name;
    protected Date penaltyEndDate;
    /**
     * Borrower 클래스의 객체 생성자. 미대출 상태로 설정, 속성 초기화 진행.
     */
    public Borrower(String name)
    {
        this.name = name;
        this.borrowInfo = new ArrayList<Loan>(10);
        this.penaltyEndDate = null;
    }

    /**
     * Borrower가 최대 대출권수를 넘었는지 확인하는 메소드
     *
     * @param  
     * @return 최대 권수를 넘지 않았다면 true, 넘었다면 false 리턴
     */
    public boolean check()
    {
        if(this.borrowInfo.size() < 10){
        return true;}
        else{return false;}
    }
    /**
     * Borrower가 연체 패널티를 지녔는지 확인하는 메소드
     *
     * @param  
     * @return 아직 연체 패널티를 가지고 있다면 true, 아니라면 false 리턴
     */
    public boolean checkOverdueBook(){
        if (penaltyEndDate == null) {
            return true;  
        }
        
        Date today = new Date();  
        return !today.after(penaltyEndDate);
    }
    /**
     * Object 클래스의 메소드 String toString() 오버라이딩
     * 
     *
     */
    public String toString(){
        return "이름 : " + name;
    }
    }