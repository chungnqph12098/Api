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
	public ResponseEntity<Users_Posts> post(@RequestBody Users_Posts postUser, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Users_PostsDAO.existsById(postUser.getId())) {
				return ResponseEntity.badRequest().build();
			}
			Users_PostsDAO.save(postUser);
			return ResponseEntity.ok(postUser);
		}
		
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Users_Posts> put(@PathVariable("x") Integer id,@RequestBody Users_Posts postUser, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Users_PostsDAO.existsById(postUser.getId()) && id==postUser.getId()) {
				Users_PostsDAO.save(postUser);
				return ResponseEntity.ok(postUser);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!Users_PostsDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		Users_PostsDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
