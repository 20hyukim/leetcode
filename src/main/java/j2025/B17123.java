package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 17123 : 배열 놀이 - 이렇게 하면 시간 초과
public class B17123 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            getResult(br);
        }

    }

    private static void getResult(BufferedReader br) throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] arrs = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < n; j ++) {
                arrs[i+1][j+1] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i < m; i++ ){
            String[] rcs = br.readLine().split(" ");
            int r1 = Integer.parseInt(rcs[0]);
            int c1 = Integer.parseInt(rcs[1]);
            int r2 = Integer.parseInt(rcs[2]);
            int c2 = Integer.parseInt(rcs[3]);
            int v = Integer.parseInt(rcs[4]);

            for (int r = r1; r < r2 + 1; r++ ){
                for (int c = c1; c < c2 + 1; c++ ){
                    arrs[r][c] += v;
                }
            }
        }

        int[][] result = new int[2][n];

        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < n+1; j++) {
                result[0][i-1] += arrs[i][j];
                result[1][i-1] += arrs[j][i];
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.print(result[0][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(result[1][i] + " ");
        }
        System.out.println();

    }
}
