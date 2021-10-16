package DATN.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import DATN.Class.Reply;
import DATN.Class.Reply_Vote;

public interface Reply_VoteDAO extends JpaRepository<Reply_Vote, Integer>{
	@Query("select r from Reply_Vote r where r.reply=?1")	
	List<Reply_Vote> find(Reply reply);
}
