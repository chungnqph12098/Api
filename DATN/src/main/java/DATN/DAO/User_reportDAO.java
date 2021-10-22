package DATN.DAO;



import org.springframework.data.jpa.repository.JpaRepository;


import DATN.Class.user_report;

public interface User_reportDAO extends JpaRepository<user_report, Integer>{
//	@Query("select p from Post_Vote p where p.posts=?1")	
//	List<Post_Vote> find(Posts posts);
}
