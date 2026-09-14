package example.com.Student_Management2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class StudentManagement2Application {

	public Map<String, Integer> people = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(StudentManagement2Application.class, args);
	}

	@GetMapping("/studentinfo")
	public Map<String, Integer> getStudentInfo() {
		return people;
	}

	@PostMapping("/studentinfo")
	public void setStudentInfo(
			@RequestParam String name,
			@RequestParam Integer age){
		people.put(name, age);
	}
	@DeleteMapping("/studentinfo")
	public Map<String, Integer> deleteStudent(@RequestParam String name) {
		people.remove(name);
		return people;
	}
}
