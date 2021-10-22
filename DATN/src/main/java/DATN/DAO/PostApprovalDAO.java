package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import DATN.Class.LoginOrLogout;
import DATN.Class.MyNotice;
import DATN.Class.PostApproval;




public interface PostApprovalDAO extends JpaRepository<PostApproval, Integer>{

}
