package demo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import demo.controller.UserController;
import demo.domain.User;
import demo.mapper.UserMapper;
import demo.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private static int ctn = 0;

	public UserServiceImpl() {
		System.out.println("UserServiceImpl ctn = " + ctn);
		UserServiceImpl.ctn++;
	}
	@Resource
	private UserMapper userDao;
	@Override
	public User selectUser(Long id) {
		return userDao.selectUser(id);
	}

	@Override
	public User selectUserGroup(Long id) {
		return userDao.selectUserGroup(id);
	}

	@Override
	public List<User> selectUsers(Map map) {
		return userDao.selectUsers(map);
	}

}
