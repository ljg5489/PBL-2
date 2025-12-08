package FrontGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;
/**
 * ResBookPanel 클래스: 책 등록을 위한 패널
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class RegBookPanel extends JPanel implements ActionListener
{
    protected JPanel buttonPanel;
    protected JPanel outputDataPanel;

    protected JLabel ml_BookTitle, ml_BookAuthor, ml_BookID;
    protected JTextField mtf_BookTitle, mtf_BookAuthor, mtf_BookID;
    protected JButton mb_BorrowerResister;
    protected JTextArea mta;
    protected String output = "";
    protected int index;

    public RegBookPanel(){
        ml_BookTitle = new JLabel("책 제목");
        ml_BookAuthor = new JLabel("책 저자이름");
        ml_BookID = new JLabel("책 등록번호");

        mtf_BookTitle = new JTextField("Book Title", 20);
        mtf_BookAuthor= new JTextField("Book Author", 20);
        mtf_BookID = new JTextField("Book ID", 20);

        this.add(ml_BookTitle);
        this.add(mtf_BookTitle);
        this.add(ml_BookAuthor);
        this.add(mtf_BookAuthor);
        this.add(ml_BookID);
        this.add(mtf_BookID);

        mb_BorrowerResister = new JButton("책 등록");
        this.add(mb_BorrowerResister);

        mta = new JTextArea(20, 25);
        this.add(new JScrollPane(mta));

        mb_BorrowerResister.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        LibraryApplication libApp = new LibraryApplication("선문대학교 중앙도서관");
        
        String outputTitle = libApp.registerOneBook(mtf_BookTitle.getText(),mtf_BookAuthor.getText(),mtf_BookID.getText());
        output =  "책 제목 : " + mtf_BookTitle.getText() + "\n"
            + "책 저자 : " + mtf_BookAuthor.getText() + "\n"
            + "책 등록번호 : " + mtf_BookID.getText() + "\n"
            + "-------------------------------------------------" + "\n";
        mta.append(outputTitle + "\n" + output);
    }
}