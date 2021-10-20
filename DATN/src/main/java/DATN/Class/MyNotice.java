package DATN.Class;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mynotice")
public class MyNotice implements Serializable {
	@Id
	private Integer id;
	private Integer user_id;
	private String title;	
	private String content;	
	private Integer type;
	private Date create_date;
	
}
