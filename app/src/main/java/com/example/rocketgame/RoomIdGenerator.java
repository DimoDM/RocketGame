package com.example.rocketgame;

import android.os.AsyncTask;

import java.util.Random;

public class RoomIdGenerator {
    private static Random random = new Random();
    public static final int CODE_LENGTH = 6;
    private static final int MAX_DIGIT = 10; // for the random nextInt it is actually 9
    static final String[] UPPERCASE_CHARACTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String generateCode() {
        String newCode = "";
        for (int i = 0; i < CODE_LENGTH ; i++) {
            boolean isDigit = random.nextBoolean();
            if(isDigit){
                newCode += random.nextInt(MAX_DIGIT);
            }else {
                newCode += UPPERCASE_CHARACTERS[random.nextInt(UPPERCASE_CHARACTERS.length)];
            }
        }
        return newCode;
    }
}
