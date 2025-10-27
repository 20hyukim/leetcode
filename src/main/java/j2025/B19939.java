package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 박 터뜨리기 - failed
public class B19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inps = br.readLine().split(" ");
        int n = Integer.parseInt(inps[0]);
        int k = Integer.parseInt(inps[1]);

        int[] balls = new int[k];

        n -= k;

        if ( n < 1 ) {
            System.out.println(-1);
            return;
        }


        for (int i = 0 ; i < k ; i ++) {
            balls[i%k] += 1;
            n -= 1;
        }

        if (n < 0) {
            System.out.println(-1);
            return;
        }

        int idx = 0;
        while ( n > 0) {
            balls[idx] += k;
            n -= k;
            idx ++;
        }

        if (n == 0) {
            System.out.println(1);
            return;
        }

        int max = Arrays.stream(balls).max().getAsInt();
        int min = Arrays.stream(balls).min().getAsInt();

        System.out.println(max - min - n);


    }
}
