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

import DATN.Class.LoginOrLogout;
import DATN.DAO.LoginOrLogoutDAO;

@CrossOrigin(originPatterns = "http://localhost:3000/")
@RestController
@RequestMapping("LoginOrLogout")
public class LoginOrLogoutAPI {
	@Autowired
	LoginOrLogoutDAO LoginOrLogoutDAO;
	@GetMapping("/get")
	public ResponseEntity<List<LoginOrLogout>> getfull() {
		return ResponseEntity.ok(LoginOrLogoutDAO.findAll());
	}
	@PostMapping("/Post")
	public ResponseEntity<LoginOrLogout> post(@RequestBody LoginOrLogout checklog, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (LoginOrLogoutDAO.existsById(checklog.getId())) {
				return ResponseEntity.badRequest().build();
			}
			LoginOrLogoutDAO.save(checklog);
			return ResponseEntity.ok(checklog);
		}
	}
	@PutMapping("/Put/{x}")
	public ResponseEntity<LoginOrLogout> put(@PathVariable("x") Integer id,@RequestBody LoginOrLogout checklog, BindingResult result){
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		} else {
			if (LoginOrLogoutDAO.existsById(checklog.getId()) && id==checklog.getId()) {
				LoginOrLogoutDAO.save(checklog);
				return ResponseEntity.ok(checklog);
			}
			return ResponseEntity.badRequest().build();
		}
	}
	@DeleteMapping("/Delete/{x}")
	public ResponseEntity<Void> delete(@PathVariable("x") Integer id){
		if(!LoginOrLogoutDAO.existsById(id)) {
			return ResponseEntity.ok().build();	
		}
		LoginOrLogoutDAO.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
