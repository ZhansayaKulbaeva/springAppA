package kz.bitlab.springApp.db;

import kz.bitlab.springApp.model.Task;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Long id = 3L;

    static {
        tasks.add(new Task(1L, "Task 1", "Task 1 desc", "2025-02-10", true));
        tasks.add(new Task(2L, "Task 2", "Task 2 desc", "2025-02-11", true));
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTask(Task task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTaskById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public static void deleteTask(Long id){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId().equals(id)){
                tasks.remove(i);
                break;
            }
        }
    }

    public static void updateTask(Task task) {
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId().equals(task.getId())){
                tasks.set(i, task);
                break;
            }
        }
    }
}
