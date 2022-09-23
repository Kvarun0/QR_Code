package com.test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class QRReader {
    public static void main(String[] args) {
        try {

            //Choosing Qr Code For decode
            JFileChooser ch=new JFileChooser();
            ch.showOpenDialog(null);
            File file=ch.getSelectedFile();
            if (file==null){
                throw  new Exception("invalid file");
            }

            //decoding qr Code
            Result r=new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));

            //for printing result at desktop
            JOptionPane.showMessageDialog(null,r.getText());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
