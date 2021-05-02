package common;

import java.util.Scanner;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-07 5:25 PM
 */
public class Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // String s = input.next();
        //int a = input.nextInt();
        while (true) {
            String s = input.next();
            if (s.equals("end")) break;
            System.out.println("---" + s);
        }
    }
}
