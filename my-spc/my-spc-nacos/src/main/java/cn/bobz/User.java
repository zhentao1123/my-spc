package cn.bobz;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1990568015794727362L;

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
