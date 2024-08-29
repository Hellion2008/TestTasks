package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            System.out.println(roadArr(n,m));

            n = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            System.out.println(roadArr(n,m));
        }
    }

    private static int[] getArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        return arr;
    }

    static String roadArr(int n, int m){
        int[] arr = getArray(n);
        StringBuilder builder = new StringBuilder();
        int pos = 0;

        do{
            builder.append(arr[pos]);
            pos += (m-1);
            if (pos >= n){
                pos -= n;
            }

        } while (pos != 0);

        return builder.toString();
    }
}