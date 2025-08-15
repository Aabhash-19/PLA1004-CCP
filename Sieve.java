import java.util.*;

public class Sieve {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[] num = new boolean[n+1];

        for(int i=2; i<=n; i++) {
            num[i] = true;
        }
        
        for(int p=2; p*p<=n; p++) {
            if(num[p]==true) {
                for(int j=p*p; j<=n; j=j+p) {
                    num[j]=false;
                }
            }
        }
        
        for(int z=2; z<=n; z++) {
            if (num[z]==true) {
                System.out.println(z+" ");
            }
        }
    }
}