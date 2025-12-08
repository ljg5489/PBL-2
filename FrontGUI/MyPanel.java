package FrontGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;
/**
 * LibraryApplication의 패널(Event Listener Object의 역할 겸용)
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.2)
 */
public class MyPanel extends JPanel implements ActionListener
{
    protected JPanel buttonPanel;
    protected JPanel outputDataPanel;
    private LibraryApplication libApp;
    protected JLabel ml_BorrowerName, ml_BookID;
    protected JTextField mtf_BorrowerName, mtf_BookID;
    protected JButton mb_Run;
    protected JTextArea mta;
    protected String[] loanORreturn = {"이용자 등록", "책 등록", "대출가능한 책 목록", 
        "대출 중인 책 목록","대출", "반납"};
    protected JComboBox mcb_loanORreturn;
    protected String output = "";
    protected int index;
    /**
     * main panel이 되는 MyPanel의 생성자
     *
     * 
     * 
     */
    public MyPanel(){
        ml_BorrowerName = new JLabel("이용자 이름");
        ml_BookID = new JLabel("책 등록번호");
    
        mtf_BorrowerName = new JTextField("Your Name", 20);
        mtf_BookID = new JTextField("Book ID", 20);
        mcb_loanORreturn = new JComboBox(loanORreturn);
        this.libApp = new LibraryApplication("A시립 도서관");
        this.add(ml_BorrowerName);
        this.add(mtf_BorrowerName);
        this.add(ml_BookID);
        this.add(mtf_BookID);
        this.add(new JLabel("선택"));
        this.add(mcb_loanORreturn);

        mb_Run = new JButton("실행");
        this.add(mb_Run);

        mta = new JTextArea(20, 25);
        this.add(new JScrollPane(mta));

        mcb_loanORreturn.addActionListener(this);
        mb_Run.addActionListener(this);
        

    }
    
    /**
     * 항목 선택 후 버튼을 눌렀을 시의 상호작용에 관한 메소드
     *
     * @param  발생하는 ActionEvent
     * 
     */
    public void actionPerformed(ActionEvent e){

        if(e.getSource().equals(mcb_loanORreturn)){
            JComboBox cb = (JComboBox)e.getSource();
            index = cb.getSelectedIndex(); 
        }   

        if(index == 0 && e.getSource().equals(mb_Run)){
            RegBorrowerFrame rbf = new RegBorrowerFrame(libApp);
        }
        else if(index == 1 && e.getSource().equals(mb_Run)){
            RegBookFrame rbf = new RegBookFrame(libApp);
        }
        else if(index == 2 && e.getSource().equals(mb_Run)){
            String outputTitle = libApp.displayBooksForLoan();
            mta.append(outputTitle + "\n");
        }
        else if(index == 3 && e.getSource().equals(mb_Run)){
            String outputTitle = libApp.displayBooksOnLoan();
            mta.append(outputTitle + "\n");
        }
        else if(index == 4 && e.getSource().equals(mb_Run)){
            int id = Integer.parseInt(mtf_BookID.getText());
            String outputTitle = libApp.loanOneBook(mtf_BorrowerName.getText(), id);
            mta.append(outputTitle + "\n" + output);
        }
        else if(index == 5 && e.getSource().equals(mb_Run)){
            int id = Integer.parseInt(mtf_BookID.getText());
            String outputTitle = libApp.returnOneBook(mtf_BorrowerName.getText(), id);
            mta.append(outputTitle + "\n" + output);
        }
    }
}