package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import DATN.Class.Reports;

public interface reportDAO extends JpaRepository<Reports, Integer>{
//	@Query("select p from Post_Vote p where p.posts=?1")	
//	List<Post_Vote> find(Posts posts);
}
