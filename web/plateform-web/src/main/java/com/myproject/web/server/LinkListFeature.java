package com.myproject.web.server;

import java.util.LinkedList;
import java.util.List;

public class LinkListFeature {
    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("name1"));
        personList.add(new Person("name2"));
        personList.add(new Person("name3"));
        personList.add(new Person("name4"));

        System.out.println(personList.size());
    }
}
