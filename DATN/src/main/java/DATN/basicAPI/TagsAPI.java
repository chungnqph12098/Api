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

import DATN.Class.Tags;
import DATN.DAO.TagsDAO;



@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Tags")
public class TagsAPI {
	@Autowired
	TagsDAO TagsDAO;
	@GetMapping("/get")
	public ResponseEntity<List<Tags>> getfull() {
		return ResponseEntity.ok(TagsDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<Tags> post(@RequestBody Tags reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Tags> put(@PathVariable("x") String id,@RequestBody Tags reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
}
