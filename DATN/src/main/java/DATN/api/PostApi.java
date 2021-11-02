package DATN.api;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

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

import DATN.Class.Posts;
import DATN.Class.QuestionHS;
import DATN.ClassDTO.questionHSDTO;
import DATN.DAO.Post_VoteDAO;
import DATN.DAO.UsersDAO;
import DATN.DAO.QuestionHSDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("Post")
public class PostApi {
	@Autowired
	QuestionHSDAO quetionHSDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	Post_VoteDAO post_voteDAO;
	
	@GetMapping("/get")
	public ResponseEntity<List<questionHSDTO>> getfull() {
		return ResponseEntity.ok(getList());
	}
//	@GetMapping("/get/{x}")
//	public ResponseEntity<QuestionHS> getpost(@PathVariable("x") Integer id) {
//		return ResponseEntity.ok(quetionHSDAO.findAllbyId(id));
//	}
	@PostMapping("/Post")
	public ResponseEntity<QuestionHS> post(@RequestBody QuestionHS questionHS){
		return ResponseEntity.ok(questionHS);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<QuestionHS> put(@PathVariable("x") String id,@RequestBody QuestionHS questionHS){
		return ResponseEntity.ok(questionHS);
	}
	@DeleteMapping("/delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
	public List<questionHSDTO> getList() {
		List<questionHSDTO> list =new ArrayList<questionHSDTO>();
		List<QuestionHS> listq= quetionHSDAO.findAll();
		for(QuestionHS dl:listq) {
			questionHSDTO hsdto =new questionHSDTO();
			hsdto.setHs(dl);
			hsdto.setPost_Votes(post_voteDAO.find(dl.getPosts()));
			list.add(hsdto);
		}
		return list;
	}
	
//	public Optional<questionHSDTO> getById( Integer id){
//		Optional<questionHSDTO> question = Optional.of(new questionHSDTO());
//		Optional<QuestionHS> q = quetionHSDAO.findById(id);
//		
//		return question;
//	}
}

	
