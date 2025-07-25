package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanInput {
    public static Scanner sc = new Scanner(System.in);

    public static int scanInt() {
        int num = -1;
        boolean InputBtn = true;
        while (InputBtn) {
            sc = new Scanner(System.in);
            try {
                num = sc.nextInt();
                if (num > 0) {
                    InputBtn = false;
                } else {
                    System.out.print("음수(-) 값은 사용할수 없습니다. 값을 입력하세요 :");
                    sc.next();
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                sc.next();
            }

        }
        return num;
    }

    public static String scanStr() {
        String str = "";
        sc = new Scanner(System.in);
        str = sc.next();

        return str;
    }
}
