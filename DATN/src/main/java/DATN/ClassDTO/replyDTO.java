package DATN.ClassDTO;

import java.util.List;
//fdsaf
import DATN.Class.Reply;
import DATN.Class.Reply_Vote;
import DATN.Class.Users;
import DATN.Class.QuestionHS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class replyDTO {
	private Reply reply;
	private List<Reply_Vote> reply_vote;
}
