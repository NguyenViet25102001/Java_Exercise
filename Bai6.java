
import java.util.Scanner;

public class Bai6 { // Phép nhân trong Fp

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int p = sc.nextInt();
        int W = sc.nextInt();
        int m = (int) Math.ceil(Math.log(p) / Math.log(2));
        int t = (int) Math.ceil(m / W);

        int[] A = new int[t];
        int[] B = new int[t];
        int[] C = new int[t];

        for (int i = t - 1; i >= 0; i--) {
            A[i] = sc.nextInt();
        }

        for (int i = t - 1; i >= 0; i--) {
            B[i] = sc.nextInt();
        }

        for (int i = t - 1; i >= 0; i--) {
            C[i] = 0;
        }

        int UV, U, V;
        int[] records = new int[2 * t]; // mảng nhớ của UV
        for (int i = 0; i <= t - 1; i++) {
            U = 0;
            for (int j = 0; j <= t - 1; j++) {
                UV = records[i + j] + A[i] * B[j] + U;
                U = UV / 256;
                V = UV % 256;
                records[i + j] = V;
            }

            records[i + t] = U;
        }

        System.out.print("c=a.b=[");
        for (int i = (2 * t) - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.printf("%d]", records[i]);
            } else {
                System.out.printf("%d  ", records[i]);
            }
        }
    }
}
