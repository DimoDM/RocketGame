package com.example.rocketgame.generators;

import android.graphics.Bitmap;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRGenerator {

    private QRGenerator(){

    }

    public static Bitmap generateQRBitmap(String data) {
        QRGEncoder encoder = new QRGEncoder(data, null,
                QRGContents.Type.TEXT, 400);
        return encoder.getBitmap();
    }
}
