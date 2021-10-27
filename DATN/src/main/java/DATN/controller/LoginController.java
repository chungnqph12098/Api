package DATN.controller;

	
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {
	
	@GetMapping("/notlogin")
	public String notloginWithGG() {
		return "Vui long dang nhap";
	}
	
	@GetMapping("/login")
	public String loginWithGG() {
		return "";
	}
	
	@GetMapping("/login/success")
	public String home(OAuth2AuthenticationToken oauth) {
		String name = oauth.getPrincipal().getAttribute("name");
		String email = oauth.getPrincipal().getAttribute("email");
		String info = oauth.getPrincipal().toString();
		return info;
	}
	
	
	
	
}
