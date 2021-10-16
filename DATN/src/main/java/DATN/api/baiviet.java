package DATN.api;
//package AssJava6.controller.API;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import AssJava6.Class.Account;
//import AssJava6.Class.Authority;
//import AssJava6.Class.questionHS;
//import AssJava6.DAO.AccountDAO;
//import AssJava6.DAO.AuthorityDAO;
//import AssJava6.DAO.RoleDAO;
//import AssJava6.DAO.questionHSDAO;
//
//@CrossOrigin(originPatterns = "http://localhost:3000/")
//@RestController
//@RequestMapping("baiviet")
//public class baiviet {
//	@Autowired
//	AccountDAO account;
//	@Autowired
//	AuthorityDAO authority;
//	@Autowired
//	RoleDAO role;
//	@Autowired
//	questionHSDAO questionHSDAO;
//	List<questionHS> list = new ArrayList<questionHS>();
//	@GetMapping("/get")
//	public ResponseEntity<List<Account>> getfull() {
//		return ResponseEntity.ok(account.findAll());
//	}
//	@GetMapping("/getID")
//	public ResponseEntity<List<String>> getfull1() {
//		return ResponseEntity.ok(account.findAllID());
//	}
//	@GetMapping("/get/{x}")
//	public ResponseEntity<Account> getID(@PathVariable("x") String id) {
//		Optional<Account> optional = account.findById(id);
//		if (!optional.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok(optional.get());
//	}
//
//	@PostMapping("/post")
//	public ResponseEntity<Account> postMethodName(@Validated @RequestBody Account entity, BindingResult result) {
//		if (result.hasErrors()) {
//			return ResponseEntity.badRequest().build();
//		} else {
//			if (account.existsById(entity.getUsername())) {
//				return ResponseEntity.badRequest().build();
//			}
//			account.save(entity);
//			Authority dlx=new Authority(null,account.getById(entity.getUsername()),role.getById("CUST"));
//			authority.save(dlx);
//			return ResponseEntity.ok(entity);
//		}
//	}
//
//	@PutMapping("/put/{x}")
//	public ResponseEntity<Account> put(@PathVariable("x") String user, @Validated @RequestBody Account entity,
//			BindingResult result) {
//		System.out.println(user);
//		System.out.println(entity.getUsername());
//		if (result.hasErrors()) {
//			return ResponseEntity.badRequest().build();
//		} else {
//			if (account.existsById(user)&& user.endsWith(entity.getUsername())) {
//				System.out.println("ok");
//				account.save(entity);
//				return ResponseEntity.ok(entity);
//			}
//			else {
//				System.out.println("loi");
//				return ResponseEntity.notFound().build();
//			}
//			
//		}
//	}
//	@DeleteMapping("delete/{x}")
//	public ResponseEntity<Void> delete(@PathVariable("x") String user) {
//		if (!account.existsById(user)) {
//			return ResponseEntity.notFound().build();
//		}
//		account.deleteById(user);
//		return ResponseEntity.ok().build();
//	}
//}
