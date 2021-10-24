package DATN.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DATN.Class.Users;
import DATN.ClassDTO.UserDTO;
import DATN.DAO.Post_VoteDAO;
import DATN.DAO.ReplyDAO;
import DATN.DAO.UsersDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("User")
public class UserApi {
	@Autowired
	UsersDAO usersDAO;
	@Autowired
	Post_VoteDAO post_voteDAO;
	@Autowired
	ReplyDAO replyDAO;
	

	@GetMapping("/get")
	public ResponseEntity<List<Users>> getfull() {
		return ResponseEntity.ok(usersDAO.findAll());
	}
	
	@PostMapping("/post")
	public ResponseEntity<Users> post(@RequestBody Users users, BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			if(usersDAO.existsById(users.getId())) {
				return ResponseEntity.badRequest().build();
			}
			usersDAO.save(users);
			return ResponseEntity.ok(users);
		}
		
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<Users> put(@PathVariable("x") Integer id,@Validated @RequestBody  Users users, BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}else {
			if(usersDAO.existsById(users.getId()) && id==users.getId()) {
				usersDAO.save(users);
					return ResponseEntity.ok(users);
			}
			return ResponseEntity.badRequest().build();
		}
	
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!usersDAO.existsById(id)) {
			return ResponseEntity.ok().build();
		}
		
		usersDAO.deleteById(id);
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
