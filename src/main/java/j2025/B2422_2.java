package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2422번: 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
// 오답: for 문 범위 (0 ~ n) x // (1 ~ n+1)
public class B2422_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] types = br.readLine().split(" ");
        int n = Integer.parseInt(types[0]);
        int m = Integer.parseInt(types[1]);

        boolean[][] bad = new boolean[n + 1][n + 1];
        for (int i = 0 ; i < m ; i ++) {
            String[] notMatching = br.readLine().split(" ");
            int one = Integer.parseInt(notMatching[0]);
            int other = Integer.parseInt(notMatching[1]);

            bad[one][other] = true;
            bad[other][one] = true;
        }

        int cnt = 0;
        for (int i = 1; i < n+1 ; i ++) {
            for (int j = i+1; j < n+1; j++) {
                for (int k = j+1; k < n+1; k++) {
                    if (bad[i][j] || bad[i][k] || bad[j][k]) {
                        continue;
                    }
                    cnt ++;
                }
            }
        }

        System.out.println(cnt);
    }
}
