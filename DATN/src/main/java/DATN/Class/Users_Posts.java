package DATN.Class;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users_Posts")

public class Users_Posts implements Serializable {
	@Id
	private Integer id;
	private Integer posts_id;
	private Integer status;
	private Date create_date;
	@ManyToOne
	@JoinColumn(name = "User_id")
	Users users;
}