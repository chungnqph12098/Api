package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import DATN.Class.reports;

public interface reportDAO extends JpaRepository<reports, Integer>{
//	@Query("select p from Post_Vote p where p.posts=?1")	
//	List<Post_Vote> find(Posts posts);
}
