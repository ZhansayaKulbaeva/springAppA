package kz.bitlab.springApp;

import kz.bitlab.springApp.db.DBManager;
import kz.bitlab.springApp.model.Task;
import kz.bitlab.springApp.model.Type;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

}
