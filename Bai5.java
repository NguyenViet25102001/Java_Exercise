import java.util.Scanner;

public class Bai5 { // phép cộng trên Fp

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int p, W, a, b;

        p = sc.nextInt();
        W = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        int t = (int) TinhT(p, W);
        int[] A = TinhMang(W, t, a);
        int[] B = TinhMang(W, t, b);

        TongFp(A, B, W, t, p);
    }

    static void NhapMang(int[] a, int t) {
        for (int i = 0; i < t; i++) {
            a[i] = sc.nextInt();
        }
    }

    static int[] TinhMang(int W, int t, int a) {
        int[] A = new int[t];
        int x = 0;

        for (int i = t - 1; i >= 0; i--) {
            A[x] = (int) (a / Math.pow(2, W * i));
            x++;

            a = (int) (a % Math.pow(2, W * i));
        }
        return A;
    }

    static double TinhT(int p, int W) {
        double m, t;

        m = Math.ceil(Math.log(p) / Math.log(2));
        t = Math.ceil(m / W);

        return t;
    }

    static boolean SoSanh(int[] c, int[] p) {
        while (true) {
            int i = 0;

            if (c[i] > p[i]) {
                return true;
            } else if (c[i] < p[i]) {
                return false;
            } else {
                i++;
                continue;
            }
        }
    }

    static void TongFp(int[] A, int[] B, int W, int t, int p) {
        int e = 0;
        int[] C = new int[t];

        C[t - 1] = A[t - 1] + B[t - 1];

        if (C[t - 1] > Math.pow(2, W)) {
            e = 1;
            C[t - 1] = (int) (C[t - 1] % Math.pow(2, W));
        } else {
            e = 0;
        }

        for (int i = t - 2; i >= 0; i--) {
            C[i] = A[i] + B[i] + e;

            if (C[i] > Math.pow(2, W)) {
                e = 1;
                C[i] = (int) (C[i] % Math.pow(2, W));
            } else {
                e = 0;
            }
        }

        int[] P = TinhMang(W, t, p);

        if (e == 0) {
            if (SoSanh(C, P)) {
                int[] c = new int[t];

                c[t - 1] = C[t - 1] - P[t - 1];

                if (c[t - 1] < 0) {
                    e = 1;
                    c[t - 1] = (int) (Math.pow(2, W) + c[t - 1]);
                } else {
                    e = 0;
                }

                for (int i = t - 2; i >= 0; i--) {
                    c[i] = C[i] - P[i] - e;

                    if (c[i] < 0) {
                        e = 1;
                        c[i] = (int) (Math.pow(2, W) + c[i]);
                    } else {
                        e = 0;
                    }
                }

                System.out.printf("[");
                for (int i = 0; i < t; i++) {
                    if (i == (t - 1)) {
                        System.out.printf("%d]", c[i]);
                    } else {
                        System.out.printf("%d   ", c[i]);
                    }
                }
            } else {
                System.out.printf("[");
                for (int i = 0; i < t; i++) {
                    if (i == (t - 1)) {
                        System.out.printf("%d]", C[i]);
                    } else {
                        System.out.printf("%d   ", C[i]);
                    }
                }
            }
        } else {
            int[] c = new int[t];

            c[t - 1] = C[t - 1] - P[t - 1];

            if (c[t - 1] < 0) {
                e = 1;
                c[t - 1] = (int) (Math.pow(2, W) + c[t - 1]);
            } else {
                e = 0;
            }

            for (int i = t - 2; i >= 0; i--) {
                c[i] = C[i] - P[i] - e;

                if (c[i] < 0) {
                    e = 1;
                    c[i] = (int) (Math.pow(2, W) + c[i]);
                } else {
                    e = 0;
                }
            }

            System.out.printf("[");
            for (int i = 0; i < t; i++) {
                if (i == (t - 1)) {
                    System.out.printf("%d]", c[i]);
                } else {
                    System.out.printf("%d   ", c[i]);
                }
            }
        }
    }
}