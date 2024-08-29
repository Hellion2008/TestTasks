package task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        String file1 = "src/task3/values.json";
        String file2 = "src/task3/tests.json";
        String file3 = "src/task3/report.json";

        String t = "{\"\"values\": [{\n" +
                "    \"id\": 2,\n" +
                "    \"value\": \"passed\"\n" +
                "  }, {\n" +
                "    \"id\": 41,\n" +
                "    \"value\": \"passed\"\n" +
                "  }]}";
        for (Value v: createValueClass(t)){
            System.out.println(v);
        }

    }

    static Collection<Value> createValueClass(String json){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type collectionType = new TypeToken<Collection<Value>>(){}.getType();
        return gson.fromJson(json, collectionType);
    }

    static Collection<Test> createTestClass(String json){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type collectionType = new TypeToken<Collection<Test>>(){}.getType();
        return gson.fromJson(json, collectionType);
    }
}
