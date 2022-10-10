package site.metacoding.newBlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.newBlog.domain.boards.BoardsDao;
import site.metacoding.newBlog.web.dto.response.boards.MainDto;

@RequiredArgsConstructor
@Service
public class BoardsService {
	
	private final BoardsDao boardsDao;

	public List<MainDto> 게시글목록보기(){
		return boardsDao.findAll();
	}

}
