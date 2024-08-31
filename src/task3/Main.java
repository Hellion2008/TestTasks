package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String file1 = "src/task3/values.json";
        String file2 = "src/task3/tests.json";
        String file3 = "src/task3/report.json";
        doReport(file1,file2,file3);


    }

    static void doReport(String fileNameValues, String fileNameTests, String filenameReport) throws IOException {
        Collection<Value> values = createValueClass(readFromFile(fileNameValues));
        Collection<Test> tests = createTestClass(readFromFile(fileNameTests));
        Collection<Test> report = createReport(values,tests);

        String json = new Gson().toJson(report);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filenameReport))){
            writer.write(json);
        }

    }

    static String readFromFile (String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            StringBuilder builder = new StringBuilder();
            while(reader.ready()){
                builder.append(reader.readLine());
            }
            return builder.toString();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    static Collection<Value> createValueClass(String json){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<Collection<Value>>() {}.getType();
        return gson.fromJson(json.substring(1, json.length()-1).replaceFirst("\"values\":", " ")
                , listType);
    }

    static Collection<Test> createTestClass(String json){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type collectionType = new TypeToken<Collection<Test>>(){}.getType();
        json = json.substring(1, json.length()-1).replaceFirst("\"tests\":", " ");
        return gson.fromJson(json,collectionType);
    }

    static Collection<Test> createReport(Collection<Value> values, Collection<Test> tests){
        for (Test test: tests){
            for (Value value: values){
                if (test.getId() == value.getId()){
                    test.setValue(value.value);
                }
            }
        }
        return tests;
    }
}
