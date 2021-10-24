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


import DATN.Class.ReportQuestion;
import DATN.Class.ReportReply;
import DATN.Class.Reports;
import DATN.DAO.ReportQuestionDAO;
import DATN.DAO.ReportReplyDAO;
import DATN.DAO.reportDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("ReportCh")
public class ReportChAPI {
	@Autowired
	ReportQuestionDAO ReportQuestionDAO;
	@Autowired
	ReportReplyDAO ReportReplyDAO;
	@Autowired
	reportDAO Report;
	//Report ALL
	@GetMapping("/get")
	public ResponseEntity<List<Reports>> getALL() {
		return ResponseEntity.ok(Report.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<Reports> postALL(@RequestBody Reports reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Reports> putALL(@PathVariable("x") String id,@RequestBody Reports reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> deleteALL(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
	//Question
	@GetMapping("/getQuestion")
	public ResponseEntity<List<ReportQuestion>> getQuestion() {
		return ResponseEntity.ok(ReportQuestionDAO.findAll());
	}
	@PostMapping("/PostQuestion")
	public ResponseEntity<ReportQuestion> postQuestion(@RequestBody ReportQuestion reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/PutQuestion/{x}")
	public ResponseEntity<ReportQuestion> putQuestion(@PathVariable("x") String id,@RequestBody ReportQuestion reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/DeleteQuestion/{x}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
	//Reply
	@GetMapping("/getReply")
	public ResponseEntity<List<ReportReply>> getReply() {
		return ResponseEntity.ok(ReportReplyDAO.findAll());
	}
	@PostMapping("/PostReply")
	public ResponseEntity<ReportReply> postReply(@RequestBody ReportReply reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/PutReply/{x}")
	public ResponseEntity<ReportReply> putReply(@PathVariable("x") String id,@RequestBody ReportReply reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/DeleteReply/{x}")
	public ResponseEntity<Void> deleteReply(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
}
