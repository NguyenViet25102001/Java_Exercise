
import java.util.Scanner;

public class TinhNgTo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        n = sc.nextInt();
        long a = 2;
        long b = 2;
        int d = 0;

        System.out.print("%\n");
        System.out.print("|% 20a|% 20b|% 20d|\n");

        for (int i = 1; i <= n; i++) {

            a = (a * a + 1) % n;

            b = (b * b + 1) % n;
            b = (b * b + 1) % n;
            int c = (int) Math.abs(a - b);
            d = GCD(c, n);

            if (d <= 1) {
                System.out.print("%-60s\n");
                System.out.printf("|          %d|%-20d|%-20d|\n", a, b, d);

            } else {
                System.out.print("------------------------------------------------------------\n");
                System.out.printf(String.format("|          %d|%-20d|%-20d|\n", a, b, d));
                System.out.print("------------------------------------------------------------\n");
                System.out.printf("Thua so khong tam thuong cua %d la %d", n, d);
                break;
            }

        }

    }

    static int GCD(int a, int b) {
        while (b > 0) {
            int R;
            R = a % b;
            a = b;
            b = R;
        }

        return a;
    }

}
