package DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.Posts;
import DATN.Class.Reply;
import DATN.Class.QuestionHS;


public interface quetionHSDAO extends JpaRepository<QuestionHS, Integer> {
//	@Query("select q from questionHS q where q.questionHS=?1")
//	List<Reply> find(questionHS questionHS);


}
