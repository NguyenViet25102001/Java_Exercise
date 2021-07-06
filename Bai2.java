import java.util.Scanner;

public class Bai2 { // phép cộng bội
    public static int log2(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public static int LuyThua(int CoSo, int SoMu) {
        int Answer = 1;

        for (int i = 0; i < SoMu; i++) {
            Answer *= CoSo;
        }
        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P;
        int W;

        P = sc.nextInt();
        W = sc.nextInt();
        double m = Math.ceil(log2(P));
        double t = Math.ceil(m / W);
        int z = (int) t; // biến ép kiểu của t

        int[] A = new int[z];
        int[] B = new int[z];
        int[] C = new int[z];

        for (int i = 0; i < z; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < z; i++) {
            B[i] = sc.nextInt();
        }

        int bit = 0;
        for (int i = z - 1; i >= 0; i--) {
            C[i] = (A[i] + B[i] + bit) % LuyThua(2, W);
            if ((A[i] + B[i] + bit) >= LuyThua(2, W)) {
                bit = 1;
            } else {
                bit = 0;
            }
        }
        System.out.print("A+B=(" + bit + ", [");
        for (int j = 0; j <= z - 1; j++) {
            if (j == z - 1) {
                System.out.print(C[j] + "])");
            } else {
                System.out.print(C[j] + "   ");
            }
        }
    }

}
