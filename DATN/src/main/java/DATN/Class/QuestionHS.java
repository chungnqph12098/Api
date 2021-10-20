package DATN.Class;

import java.io.Serializable;

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

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questionHS")

public class QuestionHS implements Serializable {
	@Id
	private Integer id;
	private String content;
	private Integer point;
	private String limg;
	private String title;
	private Date create_date;
	@ManyToOne
	@JoinColumn(name = "posts_id")
	Posts posts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "questionhs")
	List<Reply> reply;
}