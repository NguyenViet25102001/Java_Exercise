import java.util.Scanner;

public class Bai52 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p;
        int W;

        p = sc.nextInt();
        W = sc.nextInt();

        double m = Math.ceil(Math.log(p) / Math.log(2));
        double t = Math.ceil(m / W);
        int z = (int) t; // ép kiểu cho biến t

        int tg3 = p; // biến trung gian cho p
        int[] P = new int[z];
        int[] A = new int[z];
        int[] B = new int[z];
        int[] C = new int[z];
        for (int i = z - 1; i >= 0; i--) {
            A[i] = sc.nextInt();
        }

        for (int i = z - 1; i >= 0; i--) {
            B[i] = sc.nextInt();
        }

        for (int i = z - 1; i >= 0; i--) {
            P[i] = tg3 / LuyThua(2, i * W);
            tg3 = tg3 % LuyThua(2, i * W);
        }

        int e = 0; // bit mượn của cộng mảng C[]

        C[z - 1] = A[z - 1] + B[z - 1];
        if (C[z - 1] > LuyThua(2, W)) {
            C[z - 1] = C[z - 1] % LuyThua(2, W);
            e = 1;
        } else {
            e = 0;
        }

        for (int i = z - 2; i >= 0; i--) {
            C[i] = A[i] + B[i] + e;
            if (C[i] < LuyThua(2, W)) {
                e = 0;
            } else if (C[i] >= LuyThua(2, W)) {
                C[i] = (A[i] + B[i] + e) % LuyThua(2, W);
                e = 1;
            }
        }

        int[] Q = new int[z]; // mảng trả về kết quả
        if (e == 0) {
            if (SoSanh(C, P)) { // so sánh từng giá trị C[i] và P[i]

                Q[z - 1] = C[z - 1] - P[z - 1];

                if (Q[z - 1] < 0) {
                    Q[z - 1] = LuyThua(2, W) + Q[z - 1];
                    e = 1;
                } else {
                    e = 0;
                }
            } else {
                for (int i = z - 2; i >= 0; i--) {
                    Q[i] = C[i] - P[i] - e;
                    if (Q[i] >= 0) {
                        e = 0;
                    } else if (Q[i] < 0) {
                        Q[i] = LuyThua(2, W) + (C[i] - P[i] - e);
                        e = 1;
                    }
                }
            }
        } else {
            Q[z - 1] = C[z - 1] - P[z - 1];

            if (Q[z - 1] < 0) {
                Q[z - 1] = Q[z - 1] + LuyThua(2, W);
                e = 1;
            } else {
                e = 0;
            }

            for (int i = z - 2; i >= 0; i--) {
                Q[i] = C[i] - P[i] - e;

                if (Q[i] < 0) {
                    Q[i] = Q[i] + LuyThua(2, W);
                    e = 1;
                } else {
                    e = 0;
                }
            }
        }

        System.out.print("[");
        for (int j = z - 1; j >= 0; j--) {
            if (j == 0) {
                System.out.print(Q[j] + "]");
            } else {
                System.out.print(Q[j] + "   ");
            }
        }

    }

    public static int LuyThua(int CoSo, int SoMu) {
        int KetQua = 1;
        for (int i = 0; i < SoMu; i++) {
            KetQua *= CoSo;
        }
        return KetQua;
    }

    static boolean SoSanh(int[] C, int[] P) {
        while (true) {
            int i = 0;

            if (C[i] > P[i]) {
                return true;
            } else if (C[i] < P[i]) {
                return false;
            } else {
                i++;
                continue;
            }
        }
    }

}
