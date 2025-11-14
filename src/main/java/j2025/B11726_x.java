package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 11726번 : 2xn 타일링 - 이런 식으로 풀면 나눗셈 과정에서 int 오버플로우 발생.
public class B11726_x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int quo = n/2;


        int cnt = 0;
        for (int i = 0; i < quo+1; i ++) {
            int group = i + (n - 2*i); // 4
            int twos = i; // 1
            int ones = group - twos; // 3
            if (ones < 0) continue;
            cnt += factorial(group)  / (factorial(twos) * factorial(ones));
        }

        System.out.println(cnt%10007);
    }

    private static int factorial(int n) {
        if (n==1 || n ==0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
