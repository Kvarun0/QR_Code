package com.test;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class QRGenerator{
    public static void main(String[] args) {
        try {

            File file=new File("ab.jpg");
            String content="This is my Qr";

            ByteArrayOutputStream out= QRCode.from(content).to(ImageType.JPG).stream();
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(out.toByteArray());
            fos.close();
            System.out.println("Success");
        }catch (Exception  e){
            e.printStackTrace();
        }
    }
}
