package DATN.Class;

import java.io.Serializable;

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
@Table(name = "report_reply")
public class ReportReply implements Serializable{
	@Id
	private Integer id;
	private Integer reports_id;
	private Integer reply_id;
}
