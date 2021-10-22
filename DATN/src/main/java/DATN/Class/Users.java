package DATN.Class;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")

public class Users implements Serializable {
	@Id
	private Integer id;
	private String full_name;
	private String email;
	private Integer point;
	private String role;
	private Date create_date;
	private String Img;	
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Users_Posts> Users_Posts;
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Posts> Posts;
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<Post_Vote> Post_Vote;
	@JsonIgnore
	@OneToMany(mappedBy = "users")
	List<user_report> user_report;
}