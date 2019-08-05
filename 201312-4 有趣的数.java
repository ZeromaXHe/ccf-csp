//40分
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long count = 0;
        for (int i = 1; i < num - 2; i++) {
            count += combination(i, num - 1) * i * (num - 2 - i);
            count %= 1000000007;
        }
        System.out.println(count);
    }

    private static long combination(int n, int m) {
        if (m - n < n) return combination(m - n, m);
        else {
            long divisor = 1;
            long dividend = 1;
            for (int i = 0; i < n; i++) {
                divisor *= i + 1;
                dividend *= m - i;
                long ddgcd = gcd(dividend, divisor);
                divisor /= ddgcd;
                dividend /= ddgcd;
            }
            return dividend / divisor;//这里会溢出，所以大数做不对
        }
    }

    private static long gcd(long x, long y) {
        if (x == 0||y==1) return y;
        if (y == 0||x==1) return x;
        return gcd(y, x%y);
    }

}
// 2（01）3

// 4：(C1(3)*1*1)	1==3-2
// 2301
// 2031
// 2013

// 5：(C1(4)*1*2+C2(4)*2*1) 2==4-2
// 22301
// 23301
// 20231
// 20331
// 20313
// 20301
// 23001
// 23011
