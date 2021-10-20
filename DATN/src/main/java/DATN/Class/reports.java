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

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reports")
public class reports {
	@Id
	private Integer id;
	private String content;
	private Boolean status;
	private Date create_date;
	@ManyToOne
	@JoinColumn(name = "User_id")
	Users users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "reports")
	List<user_report> user_report;
}
