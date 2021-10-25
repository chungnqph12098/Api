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

import DATN.Class.MyNotice;
import DATN.DAO.MyNoticeDAO;



@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("MyNotice")
public class MyNoticeAPI {
	@Autowired
	MyNoticeDAO MyNoticeDAO;
	@GetMapping("/get")
	public ResponseEntity<List<MyNotice>> getfull() {
		return ResponseEntity.ok(MyNoticeDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<MyNotice> post(@RequestBody MyNotice notice, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (MyNoticeDAO.existsById(notice.getId())) {
				return ResponseEntity.badRequest().build();
			}
			MyNoticeDAO.save(notice);
			return ResponseEntity.ok(notice);
		}
		
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<MyNotice> put(@PathVariable("x") Integer id,@RequestBody MyNotice notice, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (MyNoticeDAO.existsById(notice.getId()) && id==notice.getId()) {
				MyNoticeDAO.save(notice);
				return ResponseEntity.ok(notice);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!MyNoticeDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		MyNoticeDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
