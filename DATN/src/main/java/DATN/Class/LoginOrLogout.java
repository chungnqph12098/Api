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
@Table(name = "loginorlogout")
public class LoginOrLogout implements Serializable {
	@Id
	private Integer id;
	private Integer user_id;
	private Date login;
	private Date logout;
}
