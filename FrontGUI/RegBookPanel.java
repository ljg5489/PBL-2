package FrontGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;
/**
 * ResBookPanel 클래스: 책 등록을 위한 패널
 *
* @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.2)
 */
public class RegBookPanel extends JPanel implements ActionListener
{
    protected JPanel buttonPanel;
    protected JPanel outputDataPanel;
    private LibraryApplication libApp;
    protected JLabel ml_BookTitle, ml_BookAuthor, ml_BookID;
    protected JTextField mtf_BookTitle, mtf_BookAuthor, mtf_BookID;
    protected JButton mb_BorrowerResister;
    protected JTextArea mta;
    protected String output = "";
    protected int index;

    public RegBookPanel(LibraryApplication app){
        ml_BookTitle = new JLabel("책 제목");
        ml_BookAuthor = new JLabel("책 저자이름");
        ml_BookID = new JLabel("책 등록번호");

        mtf_BookTitle = new JTextField("Book Title", 20);
        mtf_BookAuthor= new JTextField("Book Author", 20);
        mtf_BookID = new JTextField("Book ID", 20);
        this.libApp = app;
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
        int id = Integer.parseInt(mtf_BookID.getText());
        String outputTitle = libApp.registerOneBook(mtf_BookTitle.getText(),mtf_BookAuthor.getText(), id);
        output =  "책 제목 : " + mtf_BookTitle.getText() + "\n"
            + "책 저자 : " + mtf_BookAuthor.getText() + "\n"
            + "책 등록번호 : " + mtf_BookID.getText() + "\n"
            + "-------------------------------------------------" + "\n";
        mta.append(outputTitle + "\n" + output);
    }
}