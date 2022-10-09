package site.metacoding.newBlog.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.newBlog.domain.users.Users;
import site.metacoding.newBlog.domain.users.UsersDao;
import site.metacoding.newBlog.web.dto.request.JoinDto;
import site.metacoding.newBlog.web.dto.request.LoginDto;

@RequiredArgsConstructor
@Service
public class UsersService {
	
	private final UsersDao usersDao;
	
	public void 회원가입(JoinDto joinDto) {
		Users users = joinDto.toEntity();
		usersDao.insert(users);
	}
	
	public Users 로그인(LoginDto loginDto) {
		Users usersPS = usersDao.findByUsername(loginDto.getUsername());
		if(usersPS == null) {
			return null;
		}
		if(usersPS.getPassword().equals(loginDto.getPassword())) {
			return usersPS;
		}else {
			return null;
		}
	}
}
