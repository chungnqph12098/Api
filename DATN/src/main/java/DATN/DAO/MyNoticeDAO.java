package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import DATN.Class.LoginOrLogout;
import DATN.Class.MyNotice;




public interface MyNoticeDAO extends JpaRepository<MyNotice, Integer>{

}
