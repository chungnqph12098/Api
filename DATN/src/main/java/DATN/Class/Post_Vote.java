package DATN.Class;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Post_Vote")
public class Post_Vote {
	@Id
	private Integer id;
	private Integer PostPins;
	@Column(name="LikeOrDis")
	private Integer type;
	@ManyToOne
	@JoinColumn(name = "user_id")
	Users users;
	@ManyToOne
	@JoinColumn(name = "posts_id")
	Posts posts;
}
