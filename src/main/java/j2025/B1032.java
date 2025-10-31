package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1032번: 명령 프롬프트
public class B1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        String[] files = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            files[i] = br.readLine();
        }

        int len = files[0].length();
        StringBuilder result = new StringBuilder();

        boolean same = true;

        for (int l = 0; l < len ; l ++) {
            same = true;
            for (int i = 1; i < cnt; i ++) {
                if (files[0].charAt(l) != files[i].charAt(l)) {
                    same = false;
                    result.append("?");
                    break;
                }
            }
            if (same) result.append(files[0].charAt(l));
        }

        System.out.println(result);
    }
}
