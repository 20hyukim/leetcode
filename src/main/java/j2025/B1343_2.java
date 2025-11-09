package j2025;

import java.io.*;
import java.util.Objects;

// 백준 1343번 : 폴리오미노 - StringBuilder를 사용해보자.
public class B1343_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        int n = line.length();
        int cnt = 0;
        char flag = line.charAt(0);


        for (char c : line.toCharArray()) {
            if (c == '.') {
                if (flag != c) {
                    String calculated =  calculate_xs(cnt);
                    if (Objects.equals(calculated, "NPE")) {
                        bw.write(Integer.toString(-1));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    sb.append(calculated);
                    cnt = 0;
                }
                sb.append(c);
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
        sb.append(calculated);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static String calculate_xs(int cnt) {
        int quo = cnt/4;
        StringBuilder sb =new StringBuilder();

        for (int i = quo; i >= 0; i--) {
            int remain = cnt - (4*i);
            if ((remain % 2) == 0) {
                for (int x = 0; x < i; x++) {
                    sb.append("AAAA");
                }
                for (int y = 0; y < remain/2; y++) {
                    sb.append("BB");
                }
                return sb.toString();
            }
        }
        return "NPE";
    }

}
