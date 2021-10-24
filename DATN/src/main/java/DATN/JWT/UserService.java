//package DATN.JWT;
//import java.util.List;
//
//
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import org.springframework.stereotype.Service;
//
//import AssJava6.Class.Account;
//import AssJava6.Class.Authority;
//import AssJava6.DAO.AccountDAO;
//import AssJava6.DAO.AuthorityDAO;
//import DATN.Class.Users;
//import DATN.DAO.UsersDAO;
//
//@Service
//public class UserService implements UserDetailsService {
//	@Autowired
//	UsersDAO UsersDAO;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Users> user = UsersDAO.findById(Integer.valueOf(username));
//		List<GrantedAuthority> authorities = null ;
//			authorities.add(user.get().getRole());
//		User dl = new User(user.get().getEmail(), user.get().getId().toString(), authorities);
//		return dl;
//
//	}
//}
