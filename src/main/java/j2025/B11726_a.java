package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 백준 11726번 : 2xn 타일링 - Answer
/*
왜 dp[n] = dp[n-1] + dp[n-2] 인가?
- 새로운 한칸이 생겼을 때, dp[n-1]에서 세로로 하나를 채우는 경우
- dp[n-2]에서 가로로 두개를 채우는 경우
따라서 dp[n] = dp[n-1] + dp[n-2]

modulo 연산
 - (a + b) % m = ((a % m) + (b % m)) % m
    따라서 값이 유지. 작은 값에서 나누고 더해도 결과는 동일.
**/

public class B11726_a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n==0 || n==1 || n ==2) {
            System.out.println(n);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007 ;
        }

        System.out.println(dp[n]);

    }
}
