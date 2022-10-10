package site.metacoding.newBlog.web.dto.request.boarsd;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.newBlog.domain.boards.Boards;


@Setter
@Getter
public class WriteDto {
	private String title;
	private String content;
	
	public Boards toEntity(Integer usersId) {
		Boards boards = new Boards(this.title, this.content, usersId);
		return boards;
	}
}
