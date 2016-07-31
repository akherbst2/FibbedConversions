import java.util.Scanner;

/**
 * Coded as a part of a summer contest hosted by Virginia Tech's programming team.
 * Problem link:  https://pcs.spruett.me/contests/3/problems/B
 *
 * @author Alyssa Herbst
 * 7/31/16
 */
public class FibbedConversions {
    static long[] fib = new long[93];
    static{
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        for (int i=3; i< 93; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
    }

    static int search(long X) {
        for(int i = 2; i < 93; i++)
        {
            if (fib[i] == X) {
                return i;
            }
            if (fib[i] > X) {
                long d1 = Math.abs(X - fib[i - 1]);
                long d2 = Math.abs(X - fib[i]);
                if (d1 <= d2) {
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        int idx = search(X);
        if(idx < 0){
            idx = Math.abs(idx) - 2;
        }
        long D = X - fib[idx];
        System.out.println((fib[idx + 1] + ((3*D) >> 1)));
    }
}