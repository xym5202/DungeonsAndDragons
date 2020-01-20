package KnightAndDragon.util;

import java.util.Scanner;

public class Utils {
    public static Integer Scanner(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        try {
            Integer a=Integer.valueOf(str);
            return a;
        }catch (NumberFormatException ne){
            return -1;
        }
    }

    public static String StringScanner(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        return str;
    }
}
