import java.util.ArrayList;
import java.util.Arrays;

public class SegmentedSieve {
    public static ArrayList<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        ArrayList<Integer> primes = new ArrayList<>();

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }
        return primes;
    }

    public static void segmentedSieve(int L, int R) {
        if (L < 2) L = 2; // Ensure L is at least 2
        int limit = (int) Math.sqrt(R);
        ArrayList<Integer> primes = simpleSieve(limit);
        boolean[] isPrimeSegment = new boolean[R - L + 1];
        Arrays.fill(isPrimeSegment, true);

        for (int prime : primes) {
            int start = Math.max(prime * prime, (L + prime - 1) / prime * prime);
            for (int j = start; j <= R; j += prime) {
                isPrimeSegment[j - L] = false;
            }
        }

        for (int i = 0; i < isPrimeSegment.length; i++) {
            if (isPrimeSegment[i]) {
                System.out.print((i + L) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int L = 10, R = 50;
        segmentedSieve(L, R);
    }
}