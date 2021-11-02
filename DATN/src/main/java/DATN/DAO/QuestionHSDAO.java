package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.QuestionHS;


public interface QuestionHSDAO extends JpaRepository<QuestionHS, Integer> {
//	@Query("select q from QuestionHS q join reply r on q.posts_id = r.questionHS_id where q.id =1")
//	QuestionHS findAllbyId(Integer id);
}
