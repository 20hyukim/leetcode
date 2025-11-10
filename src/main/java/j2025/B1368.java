package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1368번 : 물대기 - have to try again
public class B1368 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        int[][] connections = new int[n][n];
        boolean[] visited = new boolean[n];

        // 각 논의 우물 파는 비용
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        // 논 간 연결 비용
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                connections[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCost = 0;

        // Prim 알고리즘
        for (int count = 0; count < n; count++) {
            int minCost = Integer.MAX_VALUE;
            int minIdx = -1;

            // 현재 연결 가능한 최소 비용 찾기
            for (int i = 0; i < n; i++) {
                if (!visited[i] && cost[i] < minCost) {
                    minCost = cost[i];
                    minIdx = i;
                }
            }

            visited[minIdx] = true;
            totalCost += minCost;

            // 새로 추가된 노드를 통해 다른 노드들의 비용 갱신
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    cost[i] = Math.min(cost[i], connections[i][minIdx]);
                }
            }
        }

        System.out.println(totalCost);
    }
}