package site.metacoding.newBlog.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.newBlog.service.UsersService;
import site.metacoding.newBlog.web.dto.CMRespDto;
import site.metacoding.newBlog.web.dto.request.JoinDto;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	private final UsersService usersService;
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}
	
	@PostMapping("/join")
	public @ResponseBody CMRespDto<?> join(@RequestBody @Valid JoinDto joinDto) {
		usersService.회원가입(joinDto);
		return new CMRespDto<>(1, "회원가입성공", null);
	}
}
