import java.util.Scanner;

public class Bai3 { // phép trừ bội

    public static int log2(int n) { // hàm tính log2
        if (n <= 0)
            throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static int LuyThua(int Coso, int SoMu) {
        int KetQua = 1;
        for (int i = 0; i < SoMu; i++) {
            KetQua *= Coso;
        }
        return KetQua;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P, W, a, b;
        P = sc.nextInt();
        W = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        double m = Math.ceil(log2(P)); // tính m,t
        double t = Math.ceil(m / W);
        int z = (int) t; // ép kiểu cho t

        int[] A = new int[z]; // khai báo mảng
        int[] B = new int[z];
        int[] C = new int[z];
        int tg1 = a;
        int tg2 = b;

        for (int i = z - 1; i >= 0; i--) {
            A[i] = tg1 / LuyThua(2, i * W);
            tg1 = tg1 % LuyThua(2, i * W);
        }

        for (int i = z - 1; i >= 0; i--) {
            B[i] = tg2 / LuyThua(2, i * W);
            tg2 = tg2 % LuyThua(2, i * W);
        }

        int bit = 0; // bit nhớ của phép trừ bội
        for (int i = 0; i < t; i++) {
            C[i] = A[i] - B[i] - bit;
            if (C[i] >= 0) {
                bit = 0;
            } else if (C[i] < 0) {
                C[i] = LuyThua(2, W) + (A[i] - B[i] - bit);
                bit = 1;
            }
        }
        System.out.print("c=a-b=(" + bit + ", [");
        for (int j = z - 1; j >= 0; j--) {
            if (j == 0) {
                System.out.print(C[j] + "])");
            } else {
                System.out.print(C[j] + "   ");
            }
        }

    }

}
