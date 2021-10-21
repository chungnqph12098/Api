package DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.QuestionHS;
import DATN.Class.Users;

public interface UsersDAO extends JpaRepository<Users,Integer> {
//	@Query("select u from users u where users=?1")
//	List<Users> find(Integer id);

//	@Query("select p from users q where p.users=?1")
//	List<Users> find(QuestionHS questionhs);
}
