package task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            showResult(reader.readLine());
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    static void showResult(String fileName) throws IOException {
        List<Integer> nums = new ArrayList<>();
        try(BufferedReader file = new BufferedReader(new FileReader(fileName))){
            while(file.ready()){
                nums.add(Integer.parseInt(file.readLine()));
            }
        }
        System.out.println(countMinSteps(nums.toArray(new Integer[0])));
    }

    private static int countMinSteps(Integer[] nums){
        int sum = 0;
        for (int el: nums){
            sum += el;
        }
        int  specialNum = sum / nums.length;
        int counter = 0;
        while (!isEquals(nums)){
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > specialNum) {
                    nums[i]--; counter++;
                } else if (nums[i] < specialNum){
                    nums[i]++; counter++;
                }
            }
        }
        return counter;
    }

    private static boolean isEquals(Integer[] array){
        for (int i = 0; i < array.length; i++){
            if (array[0] != array[i])
                return false;
        }
        return true;
    }
}
