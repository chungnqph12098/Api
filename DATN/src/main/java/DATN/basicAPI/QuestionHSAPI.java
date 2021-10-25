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

import DATN.Class.QuestionHS;
import DATN.DAO.QuestionHSDAO;



@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("QuestionHS")
public class QuestionHSAPI {
	@Autowired
	QuestionHSDAO QuestionHSDAO;
	@GetMapping("/get")
	public ResponseEntity<List<QuestionHS>> getfull() {
		return ResponseEntity.ok(QuestionHSDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<QuestionHS> post(@RequestBody QuestionHS questionHS, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (QuestionHSDAO.existsById(questionHS.getId())) {
				return ResponseEntity.badRequest().build();
			}
			QuestionHSDAO.save(questionHS);
			return ResponseEntity.ok(questionHS);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<QuestionHS> put(@PathVariable("x") Integer id,@RequestBody QuestionHS questionHS, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (QuestionHSDAO.existsById(questionHS.getId()) && id==questionHS.getId()) {
				QuestionHSDAO.save(questionHS);
				return ResponseEntity.ok(questionHS);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!QuestionHSDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		QuestionHSDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
