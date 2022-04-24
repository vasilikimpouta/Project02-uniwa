package repository;

import model.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository {

//    I am using a set to ensure the uniqueness of each student.
    private final Set<Student> students = new HashSet<>();

    public Set<Student> findNotDeleted() {
        Set<Student> results = new HashSet<>();
        for (Student student : this.students) {
            if (!student.isDeleted()) {
                results.add(student);
            }
        }
        return results;
    }

    public Set<Student> findDeleted() {
        Set<Student> deletedStudents = new HashSet<>();
        for (Student student : this.students) {
            if (student.isDeleted()) {
                deletedStudents.add(student);
            }

        }
        return deletedStudents;
    }

    public void addStudent(Student student) {
        if (this.students.contains(student)) {
            System.err.println("Student exists");
        } else {
            this.students.add(student);
        }
    }

    public Set<Student> findByNameAndNotDeleted(String searchTerm) {
        Set<Student> results = new HashSet<>();
        for (Student student : this.students) {
            if (
                    !student.isDeleted() &&
                            (student.getFirstName()
                                    .toLowerCase()
                                    .startsWith(searchTerm.toLowerCase())
                                    || student.getLastName()
                                    .toLowerCase()
                                    .startsWith(searchTerm.toLowerCase()))
            ) {
                results.add(student);
            }
        }
        return results;
    }

    public Student findByEmail(String email) {
        for (Student student : this.students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteById(String id) {
        for (Student student : this.students) {
            if (student.getId().equals(id)) {
                student.setDeleted(true);
                return student.isDeleted();
            }
        }
        return false;
    }

    public boolean removeById(String id) {
        for(Student student : this.students){
            if(student.getId().equals(id)){
               return students.remove(student);
            }
        }
        return false;
    }

    public Student findById(String id) {
        for(Student student :students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }


}
