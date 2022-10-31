package com.finalex.projectapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalex.projectapp.data.Student;
import com.finalex.projectapp.fileService.StudentFileService;

@Service
public class Studentservice {
    // duplicateCounter and anotherTester variables for a familiar style unique id
    // checking
    private int duplicateCounter = 0;

    private String anotherTester = "";
    // arraylist of students is created
    private List<Student> students = new ArrayList<>();

    //just an afterthought
    @Autowired
    StudentFileService sfileservice;

    // test and morph the given string until it is unique
    public String testForDuplicates(String tester) {
        try {
            
        boolean didItHappen = false;
        for (Student student2 : students) {
            if (tester.equals(student2.getAlphId())) {
                didItHappen = true;
                duplicateCounter++;
                anotherTester = tester.substring(0, 4);
                anotherTester += Integer.toString(duplicateCounter);
                int len = tester.length();
                anotherTester += tester.substring(len - 2, len);
            }
        }

        if (didItHappen) {
            testForDuplicates(anotherTester);

            return anotherTester;

        } else {
            duplicateCounter = 0;
            return tester;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }

    // add a student to the list
    public void addStudent(Student student) {
        students.add(student);
        String protoAlphId = student.testAlphId();

        protoAlphId = testForDuplicates(protoAlphId);

        student.setAlphId(protoAlphId);
    }

    // return all students
    public List<Student> getAllStudents() {
        return students;
    }

    // return one student via numeric id
    public Student getById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // delete one student if the id received from the controller matches the one on
    // the object
    public void deleteById(long id) {
        students.removeIf(student -> student.getId() == (id));
    }

    // return one student via familiar id
    public Student searchByAlphId(String alphid) {

        for (Student student : students) {
            if (alphid.equals(student.getAlphId())) {
                return student;
            }
        }
        return null;
    }

    // return a list of students with a particular first name
    public ArrayList<Student> searchByFirstName(String fname) {

        ArrayList<Student> foundFirstNames = new ArrayList<>();

        for (Student student : students) {
            if (fname.equals(student.getFirstName())) {
                foundFirstNames.add(student);
            }
        }
        return foundFirstNames;
    }

    // return a list of students with a particular last name
    public ArrayList<Student> searchByLastName(String lname) {

        ArrayList<Student> foundLastNames = new ArrayList<>();

        for (Student student : students) {
            if (lname.equals(student.getLastName())) {
                foundLastNames.add(student);
            }
        }
        return foundLastNames;
    }
}
