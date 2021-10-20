package DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.Reply;
import DATN.Class.QuestionHS;




public interface ReplyDAO extends JpaRepository<Reply, Integer>{
//	@Query("select r from Reply r where r.questionhs=?1")
//	List<Reply> find(questionHS question);
}
