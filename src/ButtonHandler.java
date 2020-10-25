
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Stack;
import javax.swing.text.html.HTML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azizu
 */
public class ButtonHandler implements ActionListener {

    private GUI ref;
    Stack<String> pStack;
    Stack<String> nStack;

    public ButtonHandler(GUI gui) {
        this.ref = gui;
        pStack = new Stack();
        nStack = new Stack();
        try {
            File f = new File("a-simple.file");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String line = br.readLine();
            while(line != null && !line.isEmpty()){
                nStack.push(line);
                line = br.readLine();
            }
            
            while(!nStack.isEmpty()){
                pStack.push(nStack.pop());
            }
            
            ref.textFiled.setText(pStack.pop());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "<": {
                if(!nStack.isEmpty()){
                    pStack.push(ref.textFiled.getText());
                    ref.textFiled.setText(nStack.pop());
                }else{
                    ref.prevoiusBtn.setEnabled(false);
                }
                if(!pStack.isEmpty()){
                    ref.nextBtn.setEnabled(true);
                }
                
                if(nStack.isEmpty()){
                    ref.prevoiusBtn.setEnabled(false);
                }
                break;
            }
            case ">": {
                if(!pStack.isEmpty()){
                    nStack.push(ref.textFiled.getText());
                    ref.textFiled.setText(pStack.pop());
                }else{
                    ref.nextBtn.setEnabled(false);
                }
                if(!nStack.isEmpty()){
                    ref.prevoiusBtn.setEnabled(true);
                }
                
                if(pStack.isEmpty()){
                    ref.nextBtn.setEnabled(false);
                }
                
                break;
            }
        }
    }

}
