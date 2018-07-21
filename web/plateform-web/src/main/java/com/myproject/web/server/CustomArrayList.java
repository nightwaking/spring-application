package com.myproject.web.server;

public class CustomArrayList {
    public static void main(String[] args) {
        Person[] personList = new Person[5];
        personList[0] = new Person("name0");
        personList[1] = new Person("name1");
        personList[2] = new Person("name2");
        personList[3] = new Person("name3");
        personList[4] = new Person("name4");
        Person[] newPerson = add(personList);
        System.out.println(newPerson.length);
    }

    public static Person[] add(Person[] personList) {
        Person[] newPerson = new Person[10];
        System.arraycopy(personList, 0, newPerson, 0, personList.length);
        return newPerson;
    }
}
