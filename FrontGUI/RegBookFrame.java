package FrontGUI;
import CoreEngine.*;
import javax.swing.*;
/**
 * RegBookFrame 클래스: 책 등록을 위한 프레임
 *
 * @author (2022320005 이진규, 2022320009 이상원, 2024320060 전채금)
 * @version (2025.12.2)
 */
public class RegBookFrame extends JFrame
{
    public RegBookFrame(LibraryApplication app){
        this.setTitle("도서관 관리 시스템");
        this.setSize(297, 550);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.add(new RegBookPanel(app));
    }
}