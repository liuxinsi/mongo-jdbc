package com.lxs.mj;


import java.util.List;
import java.util.Set;

/**
 * @author 刘馨思
 */
public class EmbeddedObject {
    private String embeddedStr;
    private List<TestObject> testObjectList;
    private Set<String> someCodeSet;

    public String getEmbeddedStr() {
        return embeddedStr;
    }

    public void setEmbeddedStr(String embeddedStr) {
        this.embeddedStr = embeddedStr;
    }

    public List<TestObject> getTestObjectList() {
        return testObjectList;
    }

    public void setTestObjectList(List<TestObject> testObjectList) {
        this.testObjectList = testObjectList;
    }

    public Set<String> getSomeCodeSet() {
        return someCodeSet;
    }

    public void setSomeCodeSet(Set<String> someCodeSet) {
        this.someCodeSet = someCodeSet;
    }
}
