package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\files\\nums.txt");
        File file2 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\files\\numsss.txt");
        File file3 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\files\\merge.txt");

        ex1(file1, file2, file3);
        // ex2(file2,5);


    }

    public static void ex1(File f1, File f2, File f3) {
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;
        OutputStream outputStream = null;
        try {
            inputStream1 = new FileInputStream(f1);
            inputStream2 = new FileInputStream(f2);
            outputStream = new FileOutputStream(f3);

            // נעבור על כל קובץ וכל פעם נקרא תו בודד משני הקבצים ונשאל מי ייותר גדול ממי ואת הגדול מביניהם נכתוב לקובץ 3
            //וכך נמשיך עד לסוף שאז הרשימה שנשארה נשרשר אותה
            byte[] buffer = new byte[4];
            byte[] buffer2 = new byte[4];
            int actuallyRead;
            int actuallyRead2;
            int b, c;
            while ((actuallyRead = inputStream1.read(buffer)) != -1) {
                c = ByteBuffer.wrap(buffer).getInt();
                while ((actuallyRead2 = inputStream2.read(buffer2)) != -1) {
                    b = ByteBuffer.wrap(buffer2).getInt();
                    if (c >= b) {
                        outputStream.write(b);
                    } else {
                        outputStream.write(c);
                        break;
                    }// אני באמצע התרגיל הוא לא גמור סופית..ה רעיון כתוב למעלה
                }
            }
            //בתחילה חשבתי לעשות בדרך הזו אך שמעתי שאמרת למישהי שזבה לא טוב אז חשבתי על דרך אחרת
            // לכתוב אתכל הקובץ למערכים ואז להפעיל עליהם  מיזוג ולהחזיר לקובץ 3
           /* byte bytes[] = new byte[2 * 1024];
            int actuallyRead;
            while ((actuallyRead = inputStream1.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, actuallyRead - 1));
                int temp = ByteBuffer.wrap(bytes).getInt();
            }
            byte bytes2[] = new byte[2 * 1024];
            while ((actuallyRead = inputStream1.read(bytes2)) != -1) {
                System.out.println(new String(bytes2, 0, actuallyRead - 1));
            }
            mergeSort(temp,0,bytes.length);*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream1 != null) inputStream1.close();
            } catch (Exception ex) {
            }
        }
    }


    public static int[] ex2(File file, int k) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[4];
            int actuallyRead;

            int[] arr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }

            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                if (actuallyRead != 4)
                    throw new InvalidParameterException();
                int temp = ByteBuffer.wrap(buffer).getInt();

                int max = Integer.MIN_VALUE;
                int position = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                        position = i;
                    }
                }
                if (max > temp)
                    arr[position] = temp;
            }
            return arr;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int[] ex3(File file) {
// מבנה הנתונים שהכי מתאים לדעתי הוא HASHMAP משום שהוא שומר גם ערך וגם מפתח ואז כל יש לו אתה מידע ויוכל להחזיר כל מילה כמה פעמים היתה

        return null;
    }


//קשור לכמה אינטים כבר ראיתי

}
