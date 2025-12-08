package FrontGUI;

import javax.swing.*;
/**
 * RegUserFrame 클래스: 이용자 등록 기능을 위한 프레임
 *
 * @author (2024320060 전채금)
 * @version (2025.12.03)
 */
public class RegBorrowerFrame extends JFrame
{
    public RegBorrowerFrame(){
        this.setTitle("도서관 관리 시스템");
        this.setSize(297, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        this.add(new RegBorrowerPanel());
    }
}