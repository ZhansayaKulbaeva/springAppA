package kz.bitlab.springApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    public Student(Long id, String name, String surname, int exam) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.exam = exam;
        this.mark = checkMark();
    }

    public String checkMark() {
        if (exam >= 90) return "A";
        else if (exam >= 75) return "B";
        else if (exam >= 60) return "C";
        else if (exam >= 50) return "D";
        else return "F";
    }

    public void setMark(int exam) {
        this.exam = exam;
        this.mark = checkMark();
    }
}
