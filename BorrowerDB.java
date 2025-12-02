import java.util.ArrayList;

/**
 * BorrowerDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class BorrowerDB
{
    ArrayList<Borrower> borrowerList;
    public BorrowerDB(){
        this.borrowerList = new ArrayList<Borrower>();
    }
    public Borrower searchOneBorrower(String name, int borrowerID){
        for(Borrower u: borrowerList){
            if(u.name.equals(name) && u.borrowerID == borrowerID){
                return u;
            }
        }
        return null;
    }
    public int checkSameName(String name){
        int count = 0;
        for(Borrower u : borrowerList){
            if(u.name.equals(name)){
                count++;
            }
        }
        return count+1;
    }
    public void saveOneBorrower(Borrower u){
        this.borrowerList.add(u);    
    }
}