package DATN.Class;

import java.util.Date;
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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reply")
public class Reply {
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	Users users;
	
	@ManyToOne
	@JoinColumn(name = "questionHS_id")
	QuestionHS questionhs;
	
	private String content;
	
	private Integer type;

	private Integer anonymus;
	
	private Integer status;
	
	private String Limg;
	
	private Date create_date;
	
	@JsonIgnore
	@OneToMany(mappedBy = "reply")
	List<Reply_Vote> Reply_Vote;
}
