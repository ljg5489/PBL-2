package FrontGUI;

import javax.swing.*;

/**
 * LibraryApplication의 프레임
 *
 * @author (2022320005 이진규, 2022320009 이상원)
 * @version (2025.12.2)
 */
public class MyFrame extends JFrame
{
    public MyFrame(){
        this.setTitle("도서관 관리 시스템");
        this.setSize(300, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.add(new MyPanel());
        
    }
}
