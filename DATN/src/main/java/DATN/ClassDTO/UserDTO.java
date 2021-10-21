package DATN.ClassDTO;

import java.util.List;

import DATN.Class.Users;
import DATN.Class.Users_Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Users users;
	private List<Users_Posts> users_posts;
	
}
