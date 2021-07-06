import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 2;
        int b = 2;

        System.out.println("----------------------------------------------------------------");
        System.out.println("|                   a|                   b|                   d|");
        System.out.println("----------------------------------------------------------------");

        int d = 1;
        int count = 1;
        while (true) {
            a = (a * a + 1) % n;
            b = (b * b + 1) % n;
            b = (b * b + 1) % n;

            d = TinhGCD(Math.abs(a - b), n);

            System.out.printf("|%20d|%20d|%20d|", a, b, d);

            System.out.println("\n----------------------------------------------------------------");

            count++;
            if (d > 1 && d < n) {
                System.out.println("Thua so khong tam thuong cua " + n + " la " + d);
                return;
            } else if (d == n || count == 10) {
                System.out.println("Thua so " + d + " khong phai la thua so khong tam thuong cua " + n);
                return;
            } else if (d == 1) {
                continue;
            }
        }
    }

    static int TinhGCD(int a, int b) {
        int R;
        int gcd;
        while (b > 0) {
            R = a % b;
            a = b;
            b = R;
        }
        gcd = a;
        return gcd;
    }
}