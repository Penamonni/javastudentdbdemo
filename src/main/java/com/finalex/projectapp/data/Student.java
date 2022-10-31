package com.finalex.projectapp.data;

import java.time.Year;

public class Student {
    private long id;

    private String firstName;

    private String lastName;

    private String alphId;

    private static long idCounter = 0;

    public Student() {
        this("", "");
    }

    public Student(String firstName, String lastName) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alphId = "";
    }

    public long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlphId() {
        return this.alphId;
    }

    public void setAlphId(String paramtext) {
        this.alphId = paramtext;
    }

    public String testAlphId() {
        try { 
        String combination = this.firstName.substring(0, 2);
        combination += this.lastName.substring(0, 2);
        int year = Year.now().getValue();
        String textyear = Integer.toString(year);
        int len = textyear.length();

        combination += textyear.substring(len - 2, len);

        return combination;
    }catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
