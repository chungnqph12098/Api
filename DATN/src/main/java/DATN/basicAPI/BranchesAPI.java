package DATN.basicAPI;

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

import DATN.Class.Branches;


@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Branches")
public class BranchesAPI {
	@Autowired
	DATN.DAO.BranchesDAO BranchesDAO;
	@GetMapping("/get")
	public ResponseEntity<List<Branches>> getfull() {
		return ResponseEntity.ok(BranchesDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<Branches> post(@Validated @RequestBody Branches branche, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (BranchesDAO.existsById(branche.getId())) {
				return ResponseEntity.badRequest().build();
			}
			BranchesDAO.save(branche);
			return ResponseEntity.ok(branche);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Branches> put(@PathVariable("x") Integer id,@RequestBody Branches branche,BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (BranchesDAO.existsById(branche.getId()) && id==branche.getId()) {
				BranchesDAO.save(branche);
				return ResponseEntity.ok(branche);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!BranchesDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		BranchesDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
