package site.metacoding.newBlog.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.newBlog.service.BoardsService;
import site.metacoding.newBlog.web.dto.response.boards.MainDto;

@RequiredArgsConstructor
@Controller
public class BoardsController {
	private final BoardsService boardsService;
	
	@GetMapping({"/","/boarsd"})
	public String getBoardList(Model model) {
		List<MainDto> mainDto = boardsService.게시글목록보기();
		model.addAttribute("mainDto", mainDto);
		return "boards/mainForm";
	}
	
}