package DATN.ClassDTO;

import java.util.Date;
import java.util.List;

import DATN.Class.Post_Vote;
import DATN.Class.Posts;
import DATN.Class.QuestionHS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class questionHSDTO  {
	private QuestionHS hs;
	private List<Post_Vote> post_Votes;
}