package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 11170번 : 0의 개수
public class B11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            System.out.println(getZeros(n, m));
        }
    }


    // TODO: String.valueOf(i).toCharArray(); string만 char array로 변환 가능
    private static int getZeros(int n, int m) {
        int zeros = 0;
        for (int i = n; i < m+1; i++) {
            for (char c : String.valueOf(i).toCharArray()) {
                if (c == '0') {
                    zeros ++;
                }
            }
        }
        return zeros;
    }
}
