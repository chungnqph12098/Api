package DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.Posts;
import DATN.Class.QuestionHS;
import DATN.Class.Users;


public interface quetionHSDAO extends JpaRepository<QuestionHS, Integer> {
//	@Query("select p from user p where p.posts=?1")	
//	List<Users> find(Posts posts);


}
