package com.finalex.projectapp.fileService;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.finalex.projectapp.data.Student;

@Service
public class StudentFileService {

    private List<Student> students = new ArrayList<>();

    // This package is unfortunately a bit unconnected, unfinished, unpolished and
    // untested
    // convert and save a list of students to a file
    public void writeStudentstoFile(List<Student> students) throws Exception {
        try {
            FileWriter fw = new FileWriter(new File("students.txt"), false);
            for (Student student : students) {
                String id = Long.toString(student.getId());
                String firstName = student.getFirstName();
                String lastName = student.getLastName();
                String alphId = student.getAlphId();
                fw.write(id + System.lineSeparator());
                fw.write(firstName + System.lineSeparator());
                fw.write(lastName + System.lineSeparator());
                fw.write(alphId + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // read from file line by line and create new objects to a list
    public List<Student> readStudentsFromFile() {
        try {

            Scanner scanner = new Scanner(new File("students.txt"));
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                scanner.nextLine();
                students.add(new Student(firstName, lastName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;

    }

}
