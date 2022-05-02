package repository;

import model.Student;

import java.util.HashMap;
import java.util.Map;

public class HashMapStudentRepository {

    private Map<String, Student> studentMap = new HashMap<>();

    public Student findById(String id) {
        return studentMap.get(id);
    }
}
