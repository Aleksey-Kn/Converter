import java.util.Scanner;
import java.util.regex.Pattern;

public class Converter {
    public static boolean wrong(int vr){
        if(vr < 1 || vr > 36){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] st = new String[2];
        double workingC;
        try {
            System.out.print("Enter the original number system: ");
            int now = scan.nextInt();
            System.out.print("Enter convertible number: ");
            String start = scan.next();
            if (start.contains(".")) {
                st = start.split(Pattern.quote("."));
            }
            System.out.print("Enter a score system: ");
            int result = scan.nextInt();
            if (wrong(result) || wrong(now)) {
                System.out.println("error");
                return;
            }
            if (now == 1) {
                workingC = start.length();
            } else {
                if (start.contains(".")) {
                    workingC = Integer.parseInt(st[0], now);
                    for (int i = 0; i < st[1].length(); i++) {
                        if (Character.isDigit(st[1].charAt(i))) {
                            workingC += (st[1].charAt(i) - '0') / Math.pow(now, i + 1);
                        } else {
                            workingC += (st[1].charAt(i) - 'a' + 10) / Math.pow(now, i + 1);
                        }
                    }
                } else {
                    workingC = Integer.parseInt(start, now);
                }
            }
            if (result == 1) {
                for (int i = 0; i < Math.floor(workingC); i++) {
                    System.out.print("1");
                }
            } else {
                System.out.print(Integer.toString((int) workingC, result));
                if (workingC != Math.floor(workingC)) {
                    workingC -= Math.floor(workingC);
                    System.out.print(".");
                    for (int i = 0, check; workingC != 0 && i < 5; i++) {
                        workingC *= result;
                        check = (int) workingC;
                        if (check < 10) {
                            System.out.print(check);
                        } else {
                            System.out.print((char) ('a' + check - 10));
                        }
                        workingC -= Math.floor(workingC);
                    }
                }
            }
        } catch(Exception e){
        System.out.println("error");
        }
    }
}
