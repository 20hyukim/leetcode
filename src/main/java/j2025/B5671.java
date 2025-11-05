package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 5671번 : 호텔 방 번호
public class B5671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] nm = line.split(" ");

            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int cnt = 0;
            for (int i = n ; i <= m; i++) {
                if (duplicate(i)) {
                    continue;
                }
                cnt ++;
            }

            System.out.println(cnt);
        }
    }

    private static boolean duplicate(int x) {
        boolean[] used = new boolean[10];
        String s = Integer.toString(x);

        for (char c: s.toCharArray()) {
            int digit = c - '0';
            if (used[digit]) return true;
            used[digit] = true;
        }

        return false;
    }

}
