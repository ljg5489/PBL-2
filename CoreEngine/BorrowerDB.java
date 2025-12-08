package CoreEngine;
import java.util.ArrayList;

/**
 * Borrower 객체를 저장할 수 있는 DB역할을 하는 클래스 
 * 
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.08)
 */
public class BorrowerDB
{
    private ArrayList<Borrower> borrower;
    /**
     * BorrowerDB 클래스의 객체 생성자
     */
    public BorrowerDB(){
        this.borrower = new ArrayList<Borrower>();
    }
    
    /**
     * name이 일치하는 Borrower 객체를 찾는 메소드
     *
     * @param  찾을 Borrower 객체의 name
     * @return    name이 일치하는 Borrower 객체
     */
    public Borrower searchOneBorrower(String name){
        for(Borrower u: borrower){
            if(u.name.equals(name)){
                return u;
            }
        }
        return null;
    }
    
    /**
     * 같은 이름의 Borrower 객체가 있는지 확인하는 메소드
     *
     * @param  비교할 Borrower 객체의 name
     * @return   Borrower 객체들의 name을 비교 후 같다면 true, 없다면 false 리턴
     */
    public boolean checkSameName(String name){
        for(Borrower u : borrower){
            if(u.name.equals(name)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Borrower 객체를 저장하는 메소드
     *
     * @param  저장할 Borrower 객체
     * @return   
     */
    public void saveOneBorrower(Borrower u){
        this.borrower.add(u);    
    }
}