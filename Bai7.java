import java.util.Scanner;

public class Bai7 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] agrs) {

        int t, a, b;

        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            do {
                a = sc.nextInt();
                b = sc.nextInt();
            } while (a <= 0 || b <= 0);
            int R;
            R = a % b;
            a = b;
            b = R;
            System.out.printf("%d\n", a);

        }
    }

}
