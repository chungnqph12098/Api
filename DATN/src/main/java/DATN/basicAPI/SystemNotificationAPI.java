package DATN.basicAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<SystemNotification> post(@RequestBody SystemNotification STNF, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (SystemNotificationDAO.existsById(STNF.getId())) {
				return ResponseEntity.badRequest().build();
			}
			SystemNotificationDAO.save(STNF);
			return ResponseEntity.ok(STNF);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<SystemNotification> put(@PathVariable("x") Integer id,@RequestBody SystemNotification STNF, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (SystemNotificationDAO.existsById(STNF.getId()) && id==STNF.getId()) {
				SystemNotificationDAO.save(STNF);
				return ResponseEntity.ok(STNF);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!SystemNotificationDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		SystemNotificationDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
