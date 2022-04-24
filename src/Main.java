import controller.ChoiceController;
import controller.StudentController;
import model.Student;
import repository.StudentRepository;
import service.StudentService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Application Start");
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentController studentController = new StudentController(studentService);
        Set<Integer> options = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        ChoiceController choiceController = new ChoiceController(options);
        Student stud01 = new Student(
                "Vasiliki",
                "Bouta",
                "bouta@gmail.com",
                "6988479865",
                "pliroforiki kai efarmoges");

        Student stud02 = new Student(
                "Dimitris",
                "Boutas",
                "dimbou@gmail.com",
                "690873456",
                "fusiko");

        studentRepository.addStudent(stud01);
        studentRepository.addStudent(stud02);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = choiceController.getChoice();
            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    studentController.addStudent();
                    break;
                case 2:
                    studentController.searchStudents();
                    break;
                case 3:
                    studentController.getStudents();
                    break;
                case 4:
                    studentController.deleteStudent();
                    break;

                case 5:
                    studentController.deleteStudentPermanently();
                    break;
                case 6:
                    studentController.editStudent();
                    break;
                case 7:
                    studentController.undoDelete();
                    break;
                default:
                    System.err.println("Not valid option");
                    break;
            }
        }


        System.out.println("Application end");
    }

    private static void printMenu() {
        System.out.println(" menu:");
        System.out.println(" exit : press 0 ");
        System.out.println(" menu: add a new student : press 1 ");
        System.out.println(" menu: search a student in the repository : press 2");
        System.out.println(" menu: get the list of  students  : press 3");
        System.out.println(" menu: delete a student : press 4");
        System.out.println(" menu: delete a student permanently : press 5");
        System.out.println(" menu: edit a student  : press 6");
        System.out.println(" menu: reinstate student: press 7");

    }


}
