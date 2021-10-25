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

import DATN.Class.Branches;
import DATN.Class.user_report;
import DATN.DAO.User_reportDAO;
@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("User_report")
public class User_reportAPI {
	@Autowired
	User_reportDAO User_reportDAO;
	@GetMapping("/get")
	public ResponseEntity<List<user_report>> getfull() {
		return ResponseEntity.ok(User_reportDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<user_report> post(@RequestBody user_report reportUser, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (User_reportDAO.existsById(reportUser.getId())) {
				return ResponseEntity.badRequest().build();
			}
			User_reportDAO.save(reportUser);
			return ResponseEntity.ok(reportUser);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<user_report> put(@PathVariable("x") Integer id,@RequestBody user_report reportUser, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (User_reportDAO.existsById(reportUser.getId()) && id==reportUser.getId()) {
				User_reportDAO.save(reportUser);
				return ResponseEntity.ok(reportUser);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!User_reportDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		User_reportDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
