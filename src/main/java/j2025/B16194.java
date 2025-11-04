package j2025;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 16194번 : 카드 구매하기 2
public class B16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] prices_s = br.readLine().split(" ");

        int[] prices = new int[n+1];

        for (int i = 0; i < n; i++) {
            prices[i+1] = Integer.parseInt(prices_s[i]);
        }

        // 처음에 헤맸던 이유 : min_value = Integer.MAX_VALUE; 가 아니라, prices[i]여야 된다. 자기 자신 자체도 최솟값 판단에 포함이 되기 때문.
        for (int i = 2; i < n+1; i ++) {
            int min_value = prices[i];
            for (int p = 1; p < i/2 +1; p++) {
                int cur_value = prices[p] + prices[i-p];

                if (cur_value < min_value) {
                    min_value = cur_value;
                    prices[i] = min_value;
                }
            }
        }
        System.out.println(prices[n]);

    }
}
