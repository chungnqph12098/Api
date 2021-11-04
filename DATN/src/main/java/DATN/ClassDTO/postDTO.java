package DATN.ClassDTO;

import java.util.List;

import DATN.Class.Post_Vote;
import DATN.Class.QuestionHS;
import DATN.Class.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class postDTO  {
	private QuestionHS hs;
	private List<Post_Vote> post_Votes;
}