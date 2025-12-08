package FrontGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import CoreEngine.*;
/**
 * RegBorrowerPanel 클래스: 이용자 등록을 위한 패널
 *
 * @author (2024320060 전채금)
 * @version (2025.12.03)
 */
public class RegBorrowerPanel extends JPanel implements ActionListener
{
    protected JLabel ml_BorrowerName;
    protected JTextField mtf_BorrowerName;
    protected JButton mb_BorrowerRegister;
    protected JTextArea mta;
    
    public RegBorrowerPanel(){
        ml_BorrowerName = new JLabel("");
        mtf_BorrowerName = new JTextField("이름을 입력하세요", 20);
        
        mb_BorrowerRegister = new JButton("이용자 등록");
        
        this.add(ml_BorrowerName);
        this.add(mtf_BorrowerName);
        this.add(mb_BorrowerRegister);
        
        mta = new JTextArea(10, 25);
        this.add(new JScrollPane(mta));
        
        mb_BorrowerRegister.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        LibraryApplication libApp = new LibraryApplication("선문대학교 중앙도서관");
        
        String borrowerName = mtf_BorrowerName.getText();
        String outputTitle = libApp.registerOneBorrower(borrowerName);
        
        String output = "이용자 이름 : " + borrowerName + "\n"
        + "-------------------------------------------------" + "\n";
        
        mta.append(outputTitle + "\n" + output);
        mtf_BorrowerName.setText("");
    }
}