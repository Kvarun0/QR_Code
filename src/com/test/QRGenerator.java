// Java program to create a blank text
// field of definite number of columns.
package com.test;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.*;
public class QRGenerator extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;
    // JFrame
    static JFrame f;
    // JButton
    static JButton b;
    // default constructor
    QRGenerator()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("QR Code Generator");
        // create a new button
        b = new JButton("submit");
        // create a object of the text class
        QRGenerator te = new QRGenerator();
        // addActionListener to button
        b.addActionListener(te);
        // create a object of JTextField with 16 columns
        t = new JTextField(26);
        // create a panel to add buttons and textfield
        JPanel p = new JPanel();
        // add buttons and textfield to panel
        p.add(t);
        p.add(b);
        // add panel to frame
        f.add(p);
        // set the size of frame
        f.setSize(900, 300);
        f.show();
    }
    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
         if (s.equals("submit")) {
            //l.setText(t.getText());

            // set the text of field to blank
             try {
                File file=new File("C:\\Users\\varun\\Desktop\\QRCODE_IMAGE\\abcd.jpg");
                String content=t.getText();
                 ByteArrayOutputStream out = QRCode.from(content).to(ImageType.JPG).stream();
                 FileOutputStream fos = new FileOutputStream(file);
                 fos.write(out.toByteArray());
                 fos.close();
                 System.out.println("Success");
             }catch (Exception ex){
                 ex.printStackTrace();
             }
        }
         t.setText(" ");
    }
}
