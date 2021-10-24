package DATN.basicAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DATN.Class.SystemNotification;



@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("SystemNotification")
public class SystemNotificationAPI {
	
	@Autowired
	DATN.DAO.SystemNotificationDAO SystemNotificationDAO;
	@GetMapping("/get")
	public ResponseEntity<List<SystemNotification>> getfull() {
		return ResponseEntity.ok(SystemNotificationDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<SystemNotification> post(@RequestBody SystemNotification reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<SystemNotification> put(@PathVariable("x") String id,@RequestBody SystemNotification reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
}
