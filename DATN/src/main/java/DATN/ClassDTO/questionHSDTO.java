package DATN.ClassDTO;

import java.util.List;

import DATN.Class.Posts;
import DATN.Class.QuestionHS;
import DATN.Class.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class questionHSDTO {
	private QuestionHS hs;
	private Posts posts;
	private List<Reply> reply;
}
