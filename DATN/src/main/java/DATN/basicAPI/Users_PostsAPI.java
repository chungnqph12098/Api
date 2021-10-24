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


import DATN.Class.Users_Posts;
import DATN.DAO.Users_PostsDAO;
@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Users_Posts")
public class Users_PostsAPI {
	@Autowired
	Users_PostsDAO Users_PostsDAO;
	@GetMapping("/get")
	public ResponseEntity<List<Users_Posts>> getfull() {
		return ResponseEntity.ok(Users_PostsDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<Users_Posts> post(@RequestBody Users_Posts reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Users_Posts> put(@PathVariable("x") String id,@RequestBody Users_Posts reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
}
