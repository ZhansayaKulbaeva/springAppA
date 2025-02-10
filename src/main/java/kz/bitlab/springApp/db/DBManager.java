package kz.bitlab.springApp.db;

import kz.bitlab.springApp.model.Student;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Long id = 7L;
    static {
        students.add(new Student(1L, "Zhansaya", "Kulbayeva", 80));
        students.add(new Student(2L, "Adilet", "Adikan", 74));
        students.add(new Student(3L, "Aibanu", "Uatbayeva", 90));
        students.add(new Student(4L, "Test", "Testova", 65));
        students.add(new Student(5L, "Test", "Testbekova", 55));
        students.add(new Student(6L, "Qwerty", "Qwertyievna", 40));
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student getStudentById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static void deleteById(Long id) {
        for(int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                break;
            }
        }
    }

    public static void updateStudent(Student student) {
        for(int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.set(i, student);
            }
        }
    }
}
