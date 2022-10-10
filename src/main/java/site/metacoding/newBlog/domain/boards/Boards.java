package site.metacoding.newBlog.domain.boards;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private Integer usersId;	
	private Timestamp createdAt; // At 시분초 다 표현할때, Dt 년원일

	public Boards(String title, String content, Integer usersId) {
		this.title = title;
		this.content = content;
		this.usersId = usersId;
	}
}
