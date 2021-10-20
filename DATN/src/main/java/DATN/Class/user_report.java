package DATN.Class;



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
@Table(name = "user_report")
public class user_report {
	@Id
	private Integer id;
	private Boolean LikeOrDis;
	@ManyToOne
	@JoinColumn(name = "User_id")
	Users users;
	@ManyToOne
	@JoinColumn(name = "reports_id")
	reports reports;

}
