
import java.awt.FlowLayout;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azizu
 */
public class GUI {
    
    JFrame frame;
    JButton prevoiusBtn;
    JButton nextBtn;
    JTextField textFiled;
    
    public GUI(){
        init();
    }
    
    public void init(){
        frame = new JFrame("File Reader");
        frame.setLayout(new FlowLayout());
        
        prevoiusBtn = new JButton("<");
        nextBtn = new JButton(">");
        textFiled = new JTextField(30);
        
        ButtonHandler hnd = new ButtonHandler(this);
        
        prevoiusBtn.addActionListener(hnd);
        prevoiusBtn.setEnabled(false);
        nextBtn.addActionListener(hnd);
        
        frame.add(prevoiusBtn);
        frame.add(textFiled);
        frame.add(nextBtn);
        
        frame.setLocation(200,300);
        frame.setSize(450,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
