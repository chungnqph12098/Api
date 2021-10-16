package DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.Post_Vote;
import DATN.Class.Posts;

public interface Post_VoteDAO extends JpaRepository<Post_Vote, Integer>{
	@Query("select p from Post_Vote p where p.posts=?1")	
	List<Post_Vote> find(Posts posts);
}
