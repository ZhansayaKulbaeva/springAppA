package kz.bitlab.springApp.controllers;

import kz.bitlab.springApp.db.DBManager;
import kz.bitlab.springApp.model.Task;
import kz.bitlab.springApp.model.Type;
import kz.bitlab.springApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    @PostMapping(value = "/addTask")
    public String addTask(@RequestParam("name") String name,
                          @RequestParam("desc") String desc,
                          @RequestParam("deadline") String deadline,
                          @RequestParam("userId") Long userId,
                          @RequestParam("types") List<Long> types){
        Task task = new Task();
        task.setName(name);
        task.setDescription(desc);
        task.setDeadlineDate(deadline);

        User user = DBManager.getUserById(userId);

        if (user!=null){
            task.setAuthor(user);
        }

        List<Type> typesList = new ArrayList<>();

        for (Long typeId : types){
            Type type = DBManager.getTypeById(typeId);
            typesList.add(type);
        }

        task.setTypes(typesList);

        DBManager.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id,
                              Model model) {
        model.addAttribute("types", DBManager.getTypes());
        model.addAttribute("users", DBManager.getUsers());
        model.addAttribute("task", DBManager.getTaskById(id));
        return "details";
    }

    @GetMapping("/tasks")
    public String tasksPage(Model model) {
        model.addAttribute("types", DBManager.getTypes());
        model.addAttribute("users", DBManager.getUsers());
        model.addAttribute("tasks", DBManager.getTasks());
        return "tasks";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        DBManager.deleteTask(id);
        return "redirect:/tasks";
    }

    @PutMapping("/update")
    public String updateTask(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            @RequestParam("deadline") String deadline,
            @RequestParam("completed") boolean completed,
            @RequestParam("userId") Long userId
    ){
        Task task = DBManager.getTaskById(id);
        task.setName(name);
        task.setDescription(desc);
        task.setDeadlineDate(deadline);
        task.setCompleted(completed);
        User user = DBManager.getUserById(userId);
        if (user!=null) {
            task.setAuthor(user);
        }
        DBManager.updateTask(task);
        return "redirect:/details/"+id;
    }
}
