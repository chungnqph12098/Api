package DATN.Class;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "systemnotifications")
public class SystemNotification implements Serializable {
	@Id
	private Integer id;
	private Integer user_id;
	private String title;
	private String content;
	private String sendTo;
	private Date create_date;
}
