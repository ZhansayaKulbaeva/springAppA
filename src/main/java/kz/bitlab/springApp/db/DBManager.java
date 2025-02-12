package kz.bitlab.springApp.db;

import kz.bitlab.springApp.model.Task;
import kz.bitlab.springApp.model.User;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Task> tasks = new ArrayList<>();

    private static ArrayList<User> users = new ArrayList<>();

    private static Long id = 3L;

    static {
        tasks.add(new Task(1L, "Task 1", "Task 1 desc", "2025-02-10", true, new User(1L,"Testbek Testbekovich", "qwerty@mail.ru")));
        tasks.add(new Task(2L, "Task 2", "Task 2 desc", "2025-02-11", true, new User(2L,"Testgul Testbekova", "asd@mail.ru")));
        users.add(new User(1L,"Testbek Testbekovich", "qwerty@mail.ru"));
        users.add(new User(2L,"Testgul Testbekova", "asd@mail.ru"));
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addTask(Task task) {
        task.setCompleted(false);
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

    public static User getUserById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
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
