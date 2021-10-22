package DATN.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import DATN.Class.Users;

public interface UsersDAO extends JpaRepository<Users,Integer> {

}
