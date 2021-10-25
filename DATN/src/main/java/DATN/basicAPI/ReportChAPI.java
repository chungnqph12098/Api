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
	public ResponseEntity<Reports> postALL(@RequestBody Reports report, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Report.existsById(report.getId())) {
				return ResponseEntity.badRequest().build();
			}
			Report.save(report);
			return ResponseEntity.ok(report);
		}
		
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Reports> putALL(@PathVariable("x") Integer id,@RequestBody Reports report, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Report.existsById(report.getId()) && id==report.getId()) {
				Report.save(report);
				return ResponseEntity.ok(report);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> deleteALL(@PathVariable("x") Integer id){
		if(!Report.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		Report.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//Question
	@GetMapping("/getQuestion")
	public ResponseEntity<List<ReportQuestion>> getQuestion() {
		return ResponseEntity.ok(ReportQuestionDAO.findAll());
	}
	@PostMapping("/PostQuestion")
	public ResponseEntity<ReportQuestion> postQuestion(@RequestBody ReportQuestion reportQuestion, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (ReportQuestionDAO.existsById(reportQuestion.getId())) {
				return ResponseEntity.badRequest().build();
			}
			ReportQuestionDAO.save(reportQuestion);
			return ResponseEntity.ok(reportQuestion);
		}
	}
	@PutMapping("/PutQuestion/{x}")
	public ResponseEntity<ReportQuestion> putQuestion(@PathVariable("x") Integer id,@RequestBody ReportQuestion reportQuestion, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (ReportQuestionDAO.existsById(reportQuestion.getId()) && id==reportQuestion.getId()) {
				ReportQuestionDAO.save(reportQuestion);
				return ResponseEntity.ok(reportQuestion);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/DeleteQuestion/{x}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable("x") Integer id){
		if(!ReportQuestionDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		ReportQuestionDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	//Reply
	@GetMapping("/getReply")
	public ResponseEntity<List<ReportReply>> getReply() {
		return ResponseEntity.ok(ReportReplyDAO.findAll());
	}
	@PostMapping("/PostReply")
	public ResponseEntity<ReportReply> postReply(@RequestBody ReportReply reportReply, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (ReportReplyDAO.existsById(reportReply.getId())) {
				return ResponseEntity.badRequest().build();
			}
			ReportReplyDAO.save(reportReply);
			return ResponseEntity.ok(reportReply);
		}
	}
	@PutMapping("/PutReply/{x}")
	public ResponseEntity<ReportReply> putReply(@PathVariable("x") Integer id,@RequestBody ReportReply reportReply, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (ReportReplyDAO.existsById(reportReply.getId()) && id==reportReply.getId()) {
				ReportReplyDAO.save(reportReply);
				return ResponseEntity.ok(reportReply);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/DeleteReply/{x}")
	public ResponseEntity<Void> deleteReply(@PathVariable("x") Integer id){
		if(!ReportReplyDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		ReportReplyDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
