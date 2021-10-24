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

import DATN.Class.Post_Vote;
import DATN.Class.Reply_Vote;
import DATN.DAO.Post_VoteDAO;
import DATN.DAO.Reply_VoteDAO;



@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Vote")
public class VoteAPI {
	@Autowired
	Post_VoteDAO Post_VoteDAO;
	@Autowired
	Reply_VoteDAO Reply_VoteDAO;
	//Post_Vote
	@GetMapping("/Post/get")
	public ResponseEntity<List<Post_Vote>> getPost() {
		return ResponseEntity.ok(Post_VoteDAO.findAll());
	}
	@PostMapping("/Post/Post")
	public ResponseEntity<Post_Vote> postPost(@RequestBody Post_Vote reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Post/Put/{x}")
	public ResponseEntity<Post_Vote> putPost(@PathVariable("x") String id,@RequestBody Post_Vote reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Post/Delete/{x}")
	public ResponseEntity<Void> deletePost(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
	//Reply_Vote
	@GetMapping("/Reply/get")
	public ResponseEntity<List<Reply_Vote>> getfull() {
		return ResponseEntity.ok(Reply_VoteDAO.findAll());
	}
	@PostMapping("/Reply/Post")
	public ResponseEntity<Reply_Vote> post(@RequestBody Reply_Vote reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Reply/Put/{x}")
	public ResponseEntity<Reply_Vote> put(@PathVariable("x") String id,@RequestBody Reply_Vote reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Reply/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
}
