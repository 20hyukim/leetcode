package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


// 백준 2422번: 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
public class B2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 맛의 개수 (1..n)
        int m = Integer.parseInt(st.nextToken()); // 금지 쌍 개수

        boolean[][] bad = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bad[a][b] = true;
            bad[b][a] = true;
        }

        int count = 0;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (bad[i][j]) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (bad[i][k] || bad[j][k]) continue;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
