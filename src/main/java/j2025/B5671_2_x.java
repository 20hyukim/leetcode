package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// 백준 5671 : 호텔 방 번호
public class B5671_2_x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        while (!Objects.equals(line, "") && line != null) {
            String[] nm = line.split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int cnt = 0;

            for (int i = n; i <= m; i++){
                if (isDuplicate(i)) {
                    cnt++;
                }
            }

            System.out.println(m-n-cnt+1);

            line = br.readLine();
        }
    }

    private static boolean isDuplicate(int x){
        String s = Integer.toString(x);

        boolean[] duplicate = new boolean[10];

        for (char c : s.toCharArray()) {
            int int_c = c - '0';

            if (duplicate[int_c]) return true;
            duplicate[int_c] = true;

        }
        return false;
    }
}
