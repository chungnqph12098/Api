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

import DATN.Class.QuestionHS;
import DATN.Class.Users;
import DATN.ClassDTO.UserDTO;
import DATN.ClassDTO.questionHSDTO;
import DATN.DAO.Post_VoteDAO;
import DATN.DAO.ReplyDAO;
import DATN.DAO.UsersDAO;
import DATN.DAO.quetionHSDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("User")
public class UserApi {
	@Autowired
	quetionHSDAO quetionHSDAO;
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	Post_VoteDAO post_voteDAO;
	@Autowired
	ReplyDAO replyDAO;
	

	@GetMapping("/get")
	public ResponseEntity<List<UserDTO>> getfull() {
		return ResponseEntity.ok(getList());
	}
	
	@PostMapping("/post")
	public ResponseEntity<Users> post(@RequestBody Users users){
		return ResponseEntity.ok(users);
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Users> put(@PathVariable("x") String id,@RequestBody  Users users){
		return ResponseEntity.ok(users);
	}
	@DeleteMapping("/Put/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") String id){
		return ResponseEntity.ok().build();
	}
	public List<UserDTO> getList() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		List<Users> listu = usersDAO.findAll();
		for(Users ul:listu) {
			UserDTO udto = new UserDTO();
			udto.setUsers(ul);
			list.add(udto);

		}
		return list;
	}
}
