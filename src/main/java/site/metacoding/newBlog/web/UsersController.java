package site.metacoding.newBlog.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.newBlog.domain.users.Users;
import site.metacoding.newBlog.service.UsersService;
import site.metacoding.newBlog.web.dto.CMRespDto;
import site.metacoding.newBlog.web.dto.request.users.JoinDto;
import site.metacoding.newBlog.web.dto.request.users.LoginDto;

@RequiredArgsConstructor
@Controller
public class UsersController {

	private final UsersService usersService;
	private final HttpSession session;

	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}

	@GetMapping("/mainForm")
	public String mainForm() {
		return "boards/mainForm";
	}

	@GetMapping("/loginForm")
	public String loginForm(Model model, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				model.addAttribute(cookie.getName(), cookie.getValue());

			}
		}
		return "users/loginForm";
	}

	@PostMapping("/join")
	public @ResponseBody CMRespDto<?> join(@RequestBody @Valid JoinDto joinDto) {
		usersService.회원가입(joinDto);
		return new CMRespDto<>(1, "회원가입성공", null);
	}

	@PostMapping("/login")
	public @ResponseBody CMRespDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
		Users principal = usersService.로그인(loginDto);
		if (principal == null) {
			return new CMRespDto<>(-1, "로그인 실패", null);
		}
		session.setAttribute("principal", principal);
		return new CMRespDto<>(1, "로그인성공", null);
	}
}