package FrontGUI;

import javax.swing.*;
/**
 * RegBookFrame 클래스: 책 등록을 위한 프레임
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class RegBookFrame extends JFrame
{
    public RegBookFrame(){
        this.setTitle("도서관 관리 시스템");
        this.setSize(297, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        this.add(new RegBookPanel());
    }
}