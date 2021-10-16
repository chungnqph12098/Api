package DATN.Class;

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
@Table(name = "Reply_Vote")
public class Reply_Vote {
	@Id
	private Integer id;
	private Integer LikeOrDis;
	@ManyToOne
	@JoinColumn(name = "User_id")
	Users users;
	@ManyToOne
	@JoinColumn(name = "reply_id")
	Reply reply;
}
