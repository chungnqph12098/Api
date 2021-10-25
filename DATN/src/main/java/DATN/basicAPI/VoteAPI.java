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
	public ResponseEntity<Post_Vote> postPost(@RequestBody Post_Vote postVote, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Post_VoteDAO.existsById(postVote.getId())) {
				return ResponseEntity.badRequest().build();
			}
			Post_VoteDAO.save(postVote);
			return ResponseEntity.ok(postVote);
		}
	}
	@PutMapping("/Post/Put/{x}")
	public ResponseEntity<Post_Vote> putPost(@PathVariable("x") Integer id,@RequestBody Post_Vote postVote, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Post_VoteDAO.existsById(postVote.getId()) && id==postVote.getId()) {
				Post_VoteDAO.save(postVote);
				return ResponseEntity.ok(postVote);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Post/Delete/{x}")
	public ResponseEntity<Void> deletePost(@PathVariable("x") Integer id){
		if(!Post_VoteDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		Post_VoteDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
	//Reply_Vote
	@GetMapping("/Reply/get")
	public ResponseEntity<List<Reply_Vote>> getfull() {
		return ResponseEntity.ok(Reply_VoteDAO.findAll());
	}
	@PostMapping("/Reply/Post")
	public ResponseEntity<Reply_Vote> post(@RequestBody Reply_Vote replyVote, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Reply_VoteDAO.existsById(replyVote.getId())) {
				return ResponseEntity.badRequest().build();
			}
			Reply_VoteDAO.save(replyVote);
			return ResponseEntity.ok(replyVote);
		}
	}
	@PutMapping("/Reply/Put/{x}")
	public ResponseEntity<Reply_Vote> put(@PathVariable("x") Integer id,@RequestBody Reply_Vote replyVote, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (Reply_VoteDAO.existsById(replyVote.getId()) && id==replyVote.getId()) {
				Reply_VoteDAO.save(replyVote);
				return ResponseEntity.ok(replyVote);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Reply/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!Reply_VoteDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		Reply_VoteDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
