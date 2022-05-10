package controller;

import controller.validatation.ValidInputProvider;
import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public void getStudents() {
        System.out.println(" student list ");
        List<Student> studentList = service.getStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void addStudent() {
        System.out.println("Create Student Form");
        Student details = getStudentsDetails();
        service.createStudent(details.getFirstName(), details.getLastName(), details.getEmail(),
                details.getPhoneNumber(), details.getDepartment());
    }

    private Student getStudentsDetails() {

        System.out.println("First Name:");
        String firstName = ValidInputProvider.getString();
        System.out.println("Last Name");
        String lastName = ValidInputProvider.getString();
        System.out.println("Email:");
        String email = ValidInputProvider.getEmail();
        System.out.println("PhoneNumber:");
        String phoneNumber = ValidInputProvider.getPhone();
        System.out.println("Department");
        String department = ValidInputProvider.getString();

        return new Student(firstName, lastName, email, phoneNumber, department);
    }

    public void searchStudents() {
        System.out.println(" search by name a student:");
        String searchTerm = ValidInputProvider.getString();
        List<Student> studentList = service.getStudentsByName(searchTerm);
        System.out.println("Results:");
        if (studentList.isEmpty()) {
            System.out.println("No results found");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void deleteStudent() {
        System.out.println(" choose a student from the list:");
        List<Student> studentList = service.getStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("enter the id of the student :");
        String id = ValidInputProvider.getString();
        boolean isDeleted = service.deleteStudent(id);
        if (isDeleted) {
            System.out.println(" successfully deleted");
        } else {
            System.out.println("not found ");
        }
    }

    public void deleteStudentPermanently() {
        System.out.println(" delete a student permanently :");
        List<Student> deletedStudent = service.getDeletedStudents();
        for (Student student : deletedStudent) {
            System.out.println(deletedStudent);
        }
        System.out.println(" enter the id you want to delete permanently ");
        String id = ValidInputProvider.getString();
        boolean isDeleted = service.deleteStudentPermanently(id);
        if (isDeleted) {
            System.out.println(" student successfully deleted permanently ");
        } else {
            System.out.println(" this id doesnt exist");
        }
    }

    public void editStudent() {
        System.out.println("show the list :");
        for (Student student : service.getStudents()) {
            System.out.println(student);
        }
        System.out.println("choose a student by id");
        String id = ValidInputProvider.getString();
        if (service.getStudent(id) == null) {
            System.out.println(" student not found");
            return;
        }
        System.out.println("edit Student Form");
        Student newDetails = getStudentsDetails();
        service.editStudent(id,
                newDetails.getFirstName(),
                newDetails.getLastName(),
                newDetails.getEmail(),
                newDetails.getPhoneNumber(),
                newDetails.getDepartment());
        System.out.println(" student was updated!");
    }

    public void undoDelete() {
        System.out.println("Undo delete student");
        for (Student student : service.getDeletedStudents()) {
            System.out.println(student);
        }
        System.out.println(" Enter the id of the student you want to undo the deletion");
        String id = ValidInputProvider.getString();
        boolean undone = service.undoDeleteStudent(id);
        if (undone) {
            System.out.println("Student deletion was undone");
        } else {
            System.out.println("student not found");
        }
    }
}
