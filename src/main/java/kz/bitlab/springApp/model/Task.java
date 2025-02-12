package kz.bitlab.springApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String name;
    private String description;
    private String deadlineDate;
    private boolean isCompleted;
    private User author;
    private List<Type> types;

    public Task(Long id, String name, String description, String deadlineDate, boolean isCompleted, User author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.isCompleted = isCompleted;
        this.author = author;
    }
}
