package service;

import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        Set<Student> students = repository.findNotDeleted();
        List<Student> orderedList = new ArrayList<>(students.size());
        orderedList.addAll(students);
        return orderedList;
    }

    public void createStudent(String firstName, String lastName, String email, String phoneNumber, String department) {
        Student student = new Student(
                firstName,
                lastName,
                email,
                phoneNumber,
                department
        );
        repository.addStudent(student);
    }

    public List<Student> getStudentsByName(String searchTerm) {
        Set<Student> resultSet = repository.findByNameAndNotDeleted(searchTerm);
        List<Student> studentsList = new ArrayList<>(resultSet);
        return studentsList;
    }

    public boolean deleteStudent(String id) {
        return repository.deleteById(id);
    }

    public List<Student> getDeletedStudents() {
        Set<Student> students = repository.findDeleted();
        List<Student> deletedList = new ArrayList<>(students.size());
        deletedList.addAll(students);
        return deletedList;
    }

    public boolean deleteStudentPermanently(String id) {
        return repository.removeById(id);
    }

    public void editStudent(String id, String firstName, String lastName, String email, String phoneNumber, String department) {
        Student student = repository.findById(id);
        if (student != null) {
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setEmail(email);
            student.setPhoneNumber(phoneNumber);
            student.setDepartment(department);
        }
    }

    public Student getStudent(String id) {
        return repository.findById(id);
    }

    public boolean undoDelete(String id) {
        Student student = repository.findById(id);
        if(student == null ) {
            return false;
        }
        student.setDeleted(false);
        return true;
    }
}
