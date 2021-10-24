package DATN.api;

import java.util.ArrayList;
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

import DATN.Class.Reply;
import DATN.ClassDTO.replyDTO;
import DATN.DAO.QuetionHSDAO;
import DATN.DAO.ReplyDAO;
import DATN.DAO.Reply_VoteDAO;
import DATN.DAO.UsersDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Reply")
public class ReplyApi {
	@Autowired
	ReplyDAO replyDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	Reply_VoteDAO reply_voteDAO;
	@Autowired
	QuetionHSDAO quetionHSDAO;

	
	@GetMapping("/get")
	public ResponseEntity<List<replyDTO>> getfull() {
		return ResponseEntity.ok(getList());
	}
	@PostMapping("/Post")
	public ResponseEntity<Reply> post(@RequestBody Reply reply){
		return ResponseEntity.ok(reply);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Reply> put(@PathVariable("x") String id,@RequestBody Reply reply){
		return ResponseEntity.ok(reply);
	}
	@DeleteMapping("/Put/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
	private List<replyDTO> getList() {
		List<replyDTO> list = new ArrayList<replyDTO>();
		List<Reply> listr = replyDAO.findAll();
		for(Reply l:listr) {
			replyDTO rDTO = new replyDTO();
			rDTO.setReply(l);
			rDTO.setReply_vote(reply_voteDAO.findAll());
			list.add(rDTO);
		}
		return list; 
	}


}
