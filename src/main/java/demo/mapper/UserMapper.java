package demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import demo.domain.User;

@Repository("userDao")
public interface UserMapper {

	public User selectUser(Long id);
	public User selectUser(Map<Object, Object> map);
	public User selectUserGroup(Long id);
	public List<User> selectUsers(Map map);

}
