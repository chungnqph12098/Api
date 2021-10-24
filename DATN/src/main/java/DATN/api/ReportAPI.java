package DATN.api;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import DATN.Class.Reports;
import DATN.Class.user_report;
import DATN.DAO.User_reportDAO;
import DATN.DAO.reportDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Report")
public class ReportAPI {
	@Autowired
	reportDAO reportDAO;
	@GetMapping("/get")
	public ResponseEntity<List<Reports>> getreport() {
		return ResponseEntity.ok(reportDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<Reports> post(@Validated @RequestBody Reports questionHS, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (reportDAO.existsById(questionHS.getId())) {
				return ResponseEntity.badRequest().build();
			}
			reportDAO.save(questionHS);
			return ResponseEntity.ok(questionHS);
		}
		
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Reports> put(@PathVariable("x") Integer id,@Validated @RequestBody Reports questionHS, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (reportDAO.existsById(questionHS.getId()) && id==questionHS.getId()) {
				reportDAO.save(questionHS);
				return ResponseEntity.ok(questionHS);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!reportDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		reportDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
