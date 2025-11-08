package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// 백준 1343번 : 폴리오미노
public class B1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = line.length();
        String answer = "";
        int cnt = 0;
        char flag = line.charAt(0);


        for (char c : line.toCharArray()) {
            if (c == '.') {
                if (flag != c) {
                    String calculated =  calculate_xs(cnt);
                    if (Objects.equals(calculated, "NPE")) {
                        System.out.println(-1);
                        return;
                    }
                    answer += calculated;
                    cnt = 0;
                }
                answer += c;
                flag = '.';
                continue;
            }
            cnt ++;
            flag = 'X';
        }

        //System.out.println(cnt);
        String calculated =  calculate_xs(cnt);
        if (Objects.equals(calculated, "NPE")) {
            System.out.println(-1);
            return;
        }
        answer += calculated;

        System.out.println(answer);
        return;
    }

    private static String calculate_xs(int cnt) {
        int quo = cnt/4;
        String ans = "";

        for (int i = quo; i >= 0; i--) {
            int remain = cnt - (4*i);
            if ((remain % 2) == 0) {
                for (int x = 0; x < i; x++) {
                    ans += "AAAA";
                }
                for (int y = 0; y < remain/2; y++) {
                    ans += "BB";
                }
                return ans;
            }
        }
        return "NPE";
    }

}
