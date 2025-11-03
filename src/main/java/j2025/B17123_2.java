package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 17123 : 배열 놀이
public class B17123_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i ++) {
            getResult(br);
        }
    }

    private static void getResult(BufferedReader br) throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] arrs = new int[n+1][n+1];
        int[][] diffs = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arrs[i][j] = Integer.parseInt(row[j-1]);
            }
        }

        for (int i = 0; i < m; i ++) {
            String[] rcs = br.readLine().split(" ");
            int r1 = Integer.parseInt(rcs[0]);
            int c1 = Integer.parseInt(rcs[1]);
            int r2 = Integer.parseInt(rcs[2]);
            int c2 = Integer.parseInt(rcs[3]);
            int v = Integer.parseInt(rcs[4]);

            diffs[r1][c1] += v;
            diffs[r2+1][c2+1] += v;
            diffs[r1][c2+1] -= v;
            diffs[r2+1][c1] -= v;
        }

        for (int r = 1; r < n+1; r++) {
            for (int c = 1; c < n+1; c++) {
                diffs[r][c] = diffs[r-1][c] + diffs[r][c-1] + diffs[r][c] - diffs[r-1][c-1];
                arrs[r][c] += diffs[r][c];
            }
        }

        int result = 0;
        for (int i = 1; i < n+1; i++){
            result = 0;
            for (int j = 1; j < n+1; j++) {
                result += arrs[i][j];
            }
            System.out.printf("%d ", result);
        }
        System.out.println();

        for (int i = 1; i < n+1; i++) {
            result = 0;
            for (int j =1; j < n+1; j++ ){
                result += arrs[j][i];
            }
            System.out.printf("%d ", result);
        }
        System.out.println();

    }
}
