import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int working;
        System.out.print("Введите систему счисления конвертируемого числа: ");
        int now = scan.nextInt();
        System.out.print("Введите конвертируемое число: ");
        String start = scan.next();
        System.out.print("Введите систему счисления результата: ");
        int result = scan.nextInt();
        if(now == 1){
            working = start.length();
        }
        else{
            working = Integer.parseInt(start, now);
        }
        if(result == 1){
            for(int i = 0; i < working; i++){
                System.out.print("1");
            }
        }
        else{
            System.out.println(Integer.toString(working, result));
        }
    }
}
