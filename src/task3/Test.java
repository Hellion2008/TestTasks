package task3;

import java.util.Collection;
import java.util.List;

public class Test {

    Collection<Test> values;
    String value;
    String title;
    int id;

    public Test(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Collection<Test> getValues() {
        return values;
    }

    public void setValues(Collection<Test> values) {
        this.values = values;
    }


}
