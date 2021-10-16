package DATN.Class;

import java.io.Serializable;


import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Posts")

public class Posts implements Serializable {
	@Id
	private Integer id;
	private Integer displayStatus;
	private Integer anonymus;
	private Integer type;
	@ManyToOne
	@JoinColumn(name = "User_id")
	Users users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "posts")
	List<Post_Vote> Post_Vote;
}