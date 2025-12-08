package FrontGUI;
import CoreEngine.*;
import javax.swing.*;
/**
 * RegUserFrame 클래스: 이용자 등록 기능을 위한 프레임
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.03)
 */
public class RegBorrowerFrame extends JFrame
{
    /**
     * 이용자 등록창의 Frame이 되는 RegBorrowerFrame의 생성자
     *
     * 
     */
    public RegBorrowerFrame(LibraryApplication app){
        this.setTitle("도서관 관리 시스템");
        this.setSize(297, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
        this.add(new RegBorrowerPanel(app));
    }
}