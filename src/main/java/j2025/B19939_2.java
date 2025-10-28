package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


// 박 터뜨리기 - 2nd try
public class B19939_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inps = br.readLine().split(" ");
        int n = Integer.parseInt(inps[0]);
        int k = Integer.parseInt(inps[1]);

        int minBalls = (k) * ( k+1 )/2;

        if (n < minBalls) {
            System.out.println(-1);
            return;
        }

        n -= minBalls;

        if (n % k == 0) {
            System.out.println(k-1);
            return;
        }
        System.out.println(k);
        br.close();
    }
}
