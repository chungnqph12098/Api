package DATN.basicAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import DATN.Class.QuestionHS;
import DATN.ClassDTO.postDTO;
import DATN.ClassDTO.questionHSDTO;
import DATN.DAO.QuestionHSDAO;
import DATN.DAO.ReplyDAO;



@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("QuestionHS")
public class QuestionHSAPI {
	@Autowired
	QuestionHSDAO QuestionHSDAO;
	@Autowired
	ReplyDAO replyDAO;
	@GetMapping("/get")
	public ResponseEntity<List<questionHSDTO>> getfull() {
		return ResponseEntity.ok(getList());
	}
	
	@GetMapping("/get/{x}")
	public ResponseEntity<QuestionHS> get(@PathVariable("x") Integer id) {
		return ResponseEntity.ok(QuestionHSDAO.findAllbyId(id));
	}
	
	@PostMapping("/Post")
	public ResponseEntity<QuestionHS> post(@RequestBody QuestionHS questionHS, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (QuestionHSDAO.existsById(questionHS.getId())) {
				return ResponseEntity.badRequest().build();
			}
			QuestionHSDAO.save(questionHS);
			return ResponseEntity.ok(questionHS);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<QuestionHS> put(@PathVariable("x") Integer id,@RequestBody QuestionHS questionHS, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (QuestionHSDAO.existsById(questionHS.getId()) && id==questionHS.getId()) {
				QuestionHSDAO.save(questionHS);
				return ResponseEntity.ok(questionHS);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!QuestionHSDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		QuestionHSDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	private List<questionHSDTO> getList() {
		List<questionHSDTO> list = new ArrayList<questionHSDTO>();
		List<QuestionHS> listq = QuestionHSDAO.findAll();
		for(QuestionHS ql:listq) {
			questionHSDTO hsdto = new questionHSDTO();
			hsdto.setHs(ql);
			hsdto.setPosts(ql.getPosts());
			hsdto.setReply(replyDAO.find(ql));
			list.add(hsdto);
		}
		
		return list;
	}
	
	public Optional<questionHSDTO> getById( Integer id){
		Optional<questionHSDTO> question = Optional.of(new questionHSDTO());
		Optional<QuestionHS> q = QuestionHSDAO.findById(id);
		
		return question;
	}
}
