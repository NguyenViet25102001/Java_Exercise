import java.util.Scanner;

public class Bai8 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] RMB = new int[n + 1];
        int p = n;

        GanGiaTri(RMB, n);
        LietKe(n);
        SoNguyenTo(p, n, RMB);
        InRaSoNgt(RMB, n);
    }

    static void LietKe(int n) {
        System.out.printf("Liet ke cac so nguyen tu 2 den %d\n", n); // in ra tu 2 den n
        for (int i = 2; i <= n; i++) {
            System.out.printf("%d  ", i);
        }
    }

    static void GanGiaTri(int[] a, int n) {
        for (int i = 2; i <= n; i++) {
            a[i] = i;
        }
    }

    static void SoNguyenTo(int p, int n, int[] a) {
        for (int i = 2; i <= n; i++) {
            a[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (a[i] == 1) {
                System.out.printf("\np=%d\n", i);
                for (int j = i * i; j <= n; j += i) {
                    a[j] = 0;
                }
            }

            if (a[i] == 1) {
                for (int j = 2; j <= n; j++) {
                    if (a[j] == 1) {
                        System.out.printf("%d  ", j);
                    }
                }
            }
        }
    }

    static void InRaSoNgt(int[] a, int n) {
        System.out.printf("\nCac so nguyen to <=%d la:\n", n);
        for (int i = 2; i <= n; i++) {
            if (a[i] == 1) {
                System.out.printf("%d  ", i);
            }
        }
    }
}