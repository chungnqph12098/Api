package DATN.api;

import java.util.ArrayList;
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

import DATN.Class.Reply;
import DATN.ClassDTO.replyDTO;
import DATN.DAO.QuestionHSDAO;
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
	QuestionHSDAO quetionHSDAO;

	
	@GetMapping("/get")
	public ResponseEntity<List<replyDTO>> getfull() {
		return ResponseEntity.ok(getList());
	}
	@PostMapping("/Post")
	public ResponseEntity<Reply> post(@RequestBody Reply reply,BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			if(replyDAO.existsById(reply.getId())) {
				return ResponseEntity.badRequest().build();
			}
			replyDAO.save(reply);
			return ResponseEntity.ok(reply);
		}
		
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Reply> put(@PathVariable("x") Integer id,@RequestBody Reply reply, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (replyDAO.existsById(reply.getId()) && id==reply.getId()) {
				replyDAO.save(reply);
				return ResponseEntity.ok(reply);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!replyDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		replyDAO.deleteById(id);
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
