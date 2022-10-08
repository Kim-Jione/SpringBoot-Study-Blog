package site.metacoding.newBlog.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.newBlog.domain.users.Users;
import site.metacoding.newBlog.domain.users.UsersDao;
import site.metacoding.newBlog.web.dto.request.JoinDto;

@RequiredArgsConstructor
@Service
public class UsersService {
	
	private final UsersDao usersDao;
	
	public void 회원가입(JoinDto joinDto) {
		Users users = joinDto.toEntity();
		usersDao.insert(users);
	}
}
