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

import DATN.Class.PostApproval;
import DATN.DAO.PostApprovalDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("PostApproval")
public class PostApprovalAPi {
	@Autowired
	PostApprovalDAO PostApprovalDAO;
	@GetMapping("/get")
	public ResponseEntity<List<PostApproval>> getfull() {
		return ResponseEntity.ok(PostApprovalDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<PostApproval> post(@RequestBody PostApproval approval, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (PostApprovalDAO.existsById(approval.getId())) {
				return ResponseEntity.badRequest().build();
			}
			PostApprovalDAO.save(approval);
			return ResponseEntity.ok(approval);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<PostApproval> put(@PathVariable("x") Integer id,@RequestBody PostApproval approval, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (PostApprovalDAO.existsById(approval.getId()) && id==approval.getId()) {
				PostApprovalDAO.save(approval);
				return ResponseEntity.ok(approval);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!PostApprovalDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		PostApprovalDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
