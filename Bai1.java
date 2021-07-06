import java.util.Scanner;
import java.lang.Math;

public class Bai1 { // phân tích về dạng mảng
    public static int log2(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static int LuyThua(int coSo, int soMu) {
        int ketQua = 1;

        for (int i = 0; i < soMu; i++) {
            ketQua *= coSo;
        }
        return ketQua;
    }

    public static void xuatmang(int A[]) {
        System.out.print("Return: ");
        for (int i = A.length - 1; i >= 0; i--) {
            System.out.print("\t" + A[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P;
        int W;
        int a;

        System.out.print("Nhập số nguyên P : ");
        P = sc.nextInt();
        System.out.print("Nhập W = ");
        W = sc.nextInt();
        System.out.print("Nhập số nguyên a = ");
        a = sc.nextInt();

        double m = Math.ceil(log2(P));
        double t = Math.ceil(m / W);
        int z = (int) t;
        int[] A = new int[z];
        int tg = a;

        for (int i = z - 1; i >= 0; i--) {
            int k = (int) i * W;
            A[i] = tg / LuyThua(2, k);
            tg = tg % LuyThua(2, k);
        }

        xuatmang(A);
    }
}
