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

import DATN.Class.Subject;
import DATN.DAO.SubjectDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Subject")
public class SubjectAPI {
	@Autowired
	SubjectDAO SubjectDAO;
	@GetMapping("/get")
	public ResponseEntity<List<Subject>> getfull() {
		return ResponseEntity.ok(SubjectDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<Subject> post(@RequestBody Subject sub, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (SubjectDAO.existsById(sub.getId())) {
				return ResponseEntity.badRequest().build();
			}
			SubjectDAO.save(sub);
			return ResponseEntity.ok(sub);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Subject> put(@PathVariable("x") Integer id,@RequestBody Subject sub, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (SubjectDAO.existsById(sub.getId()) && id==sub.getId()) {
				SubjectDAO.save(sub);
				return ResponseEntity.ok(sub);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!SubjectDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		SubjectDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
