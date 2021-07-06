import java.util.Scanner;

public class SangPD {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n, m; // n la so nguyen to, m la kich co phan doan
        n = sc.nextInt();
        m = sc.nextInt();
        int[] RMB = new int[n + 1];
        ChiaPV(n, m, RMB);
    }

    static void ChiaPV(int n, int m, int[] a) {
        int count = 1;
        System.out.printf("Chia pham vi tu 2 den %d thanh cac doan co kich co %d\n", n, m);

        for (int i = 2; i <= n; i++) {
            System.out.printf("%d   ", i);

            if (count % m == 0 && count >= m) {
                System.out.printf("||");
            }
            count++;
        }
    }
}