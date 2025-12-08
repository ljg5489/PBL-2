package CoreEngine;
import java.util.ArrayList;

/**
 * BorrowerDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BorrowerDB
{
    ArrayList<Borrower> borrower;
    public BorrowerDB(){
        this.borrower = new ArrayList<Borrower>();
    }
    public Borrower searchOneBorrower(String name){
        for(Borrower u: borrower){
            if(u.name.equals(name)){
                return u;
            }
        }
        return null;
    }
    public boolean checkSameName(String name){
        for(Borrower u : borrower){
            if(u.name.equals(name)){
                return true;
            }
        }
        return false;
    }
    public void saveOneBorrower(Borrower u){
        this.borrower.add(u);    
    }
}