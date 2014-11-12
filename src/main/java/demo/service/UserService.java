package demo.service;

import java.util.List;
import java.util.Map;

import demo.domain.User;

public interface UserService {

	public User selectUser(Long id);
	public User selectUserGroup(Long id);
	
	public List<User> selectUsers(Map map);
	
	public void deleteAndInsert(User user);
}
