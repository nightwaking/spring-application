package com.myproject.web.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualsFeatures {
    public static void main(String[] args) {
        List<Person> personList= new ArrayList<>();
        Person person1 = new Person("name");
        Person person2 = new Person("name");
        personList.add(person1);

        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);

        // 返回结果为true,重写了equals方法
        System.out.println("List中包含person2:" + personList.contains(person2));
        // 返回结果为false，需要重写hashCode方法
        System.out.println("Set中包含person2:" + personSet.contains(person2));
    }
}

class Person {
    private String name;
    public Person (String name) {
        this.name = name;
    }

    /**
     * 重写父类的equals方法
     * @param obj 类
     * @return 根据条件返回的结果
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof  Person) {
            Person otherPerson = (Person) obj;
            return name.equals(otherPerson.name);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
