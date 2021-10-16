package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import DATN.Class.Posts;




public interface PostDAO extends JpaRepository<Posts, Integer>{

}
