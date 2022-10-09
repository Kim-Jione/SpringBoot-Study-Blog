package site.metacoding.newBlog.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.newBlog.domain.users.Users;

@Setter
@Getter
public class LoginDto {
	private String username;
	private String password;
}
