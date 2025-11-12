package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 5671번 : 호텔 방 번호 / 3번째 try ; triangle
public class B5671_3_s {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        // TODO: (line = br.readLine()) == null 이 아닌 경우!
        while(!((line = br.readLine()) == null) && !line.isEmpty()) {
            String[] nm = line.split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int cnt = 0;

            for (int i = n; i < m+1; i++) {
                cnt += valuable(i);
            }

            System.out.println(cnt);
        }

    }

    private static int valuable(int i) {
        String num = Integer.toString(i);
        boolean[] duplicate = new boolean[10];

        for (char n : num.toCharArray()) {
            int n_i = n - '0';

            if (! duplicate[n_i]) {
                duplicate[n_i] = true;
                continue;
            }
            return 0;
        }
        return 1;
    }
}
