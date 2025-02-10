package kz.bitlab.springApp.controllers;

import kz.bitlab.springApp.db.DBManager;
import kz.bitlab.springApp.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/details/{id}")
    public String detailsPage(@PathVariable Long id,
                              Model model) {
        model.addAttribute("task", DBManager.getTaskById(id));
        return "details";
    }

    @GetMapping("/tasks")
    public String tasksPage(Model model) {
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
            @RequestParam("completed") boolean completed
    ){
        Task task = DBManager.getTaskById(id);
        task.setName(name);
        task.setDescription(desc);
        task.setDeadlineDate(deadline);
        task.setCompleted(completed);
        DBManager.updateTask(task);
        return "redirect:/details/"+id;
    }
}
