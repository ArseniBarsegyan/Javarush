package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, "UTF-8");
        buffer = s.getBytes("Windows-1251");
        outputStream.write(buffer);

        inputStream.close();
        outputStream.close();
    }
}
