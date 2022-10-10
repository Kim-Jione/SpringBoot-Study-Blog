package site.metacoding.newBlog.domain.boards;

import java.util.List;

import site.metacoding.newBlog.web.dto.response.boards.MainDto;


public interface BoardsDao {
	public List<MainDto> findAll();
}
