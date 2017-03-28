/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgraphics.calculator;

import basicgraphics.BasicFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author sbrandt
 */
public class Calculator {
    public final static String[][] layout = {
        {"D","D","D","C"},
        {"1","2","3","+"},
        {"4","5","6","-"},
        {"7","8","9","*"},
        {"0",".","/","="}
    };
    double value_, previousValue;
    String operator;
    double decimal=1.0;
    JLabel display = new JLabel("0",JLabel.CENTER);
    public BasicFrame bf = new BasicFrame("Calculator");
    
    // This is called an accessor
    public double getValue() {
        return value_;
    }
    public void setValue(double v) {
        value_ = v;
    }
    
    public void init() {
        // Here "D" refers to the name in the
        // layout. Because "D" is repeated three
        // times, it is as wide as the three buttons
        // below it.
        bf.add(layout,"D",display);
        
        for(int i=0;i<=9;i++) {
            final int key = i;
            // Create the button, providing the display
            // text drawn on the button.
            JButton b = new JButton(""+i);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(decimal == 1.0) {
                        value_ = 10*value_+key;
                    } else {
                        value_ = value_ + key*decimal;
                        decimal *= 0.1;
                    }
                    update();
                }
            });
            // Provide the name in the layout describing
            // where the button goes.
            bf.add(layout, ""+i, b);
        }
        // Iterate through button names.
        for(String s : new String[]{"+","-","/","*","="}) {
            final String op = s;
            JButton b = new JButton(op);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if("=".equals(op)) {
                        calc(operator);
                        setValue(previousValue);
                        operator = null;
                    } else {
                        previousValue = getValue();
                        setValue(0.0);
                        operator = op;
                    }
                    decimal = 1.0;
                    update();
                }
            });
            bf.add(layout,op,b);
        }
        
        // The text on the button is "Clr"
        JButton clear = new JButton("Clr");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setValue(0.0);
                previousValue = 0;
                operator = null;
                decimal = 1.0;
                update();
            }
        });
        // The place of the button in the layout is
        // given by "C".
        bf.add(layout,"C",clear);
        
        // "." is the text on the button text
        JButton dot = new JButton(".");
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decimal *= .1;
            }
        });
        // "." is the position on the display
        bf.add(layout,".",dot);
        Font f = new Font("Courier", Font.BOLD, 30);
        bf.setAllFonts(f);
        bf.show();
    }
    public void calc(String op) {
        if ("+".equals(op)) {
            previousValue = previousValue + getValue();
        } else if ("-".equals(op)) {
            previousValue = previousValue - getValue();
        } else if ("*".equals(op)) {
            previousValue = previousValue * getValue();
        } else if ("/".equals(op)) {
            previousValue = previousValue / getValue();
        }
    }
    final static DecimalFormat df = new DecimalFormat("#.######");
    public void update() {
        if(operator == null) {
            display.setText(df.format(getValue()));
        } else {
            display.setText(df.format(previousValue)+operator+df.format(getValue()));
        }
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.init();
    }
}
