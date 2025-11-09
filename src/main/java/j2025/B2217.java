package j2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 백준 2217 : 로프
public class B2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> ropes = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes);

        int max_w = 0;
        for(int i = 0; i < n; i++) {
            max_w = Math.max(ropes.get(i) * (n - i), max_w);
        }

        System.out.println(max_w);

    }

}
