/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgraphics.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sbrandt
 */
public class MyActionListener implements ActionListener {
    
    Calculator c;
    int key;
    public MyActionListener(Calculator c,int key) {
        this.c = c;
        this.key = key;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (c.decimal == 1.0) {
            c.value_ = 10 * c.value_ + key;
        } else {
            c.value_ = c.value_ + key * c.decimal;
            c.decimal *= 0.1;
        }
        c.update();
    }

}
