package demo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import demo.common.page.Page;
import demo.domain.User;
import demo.mapper.UserMapper;
import demo.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private static int ctn = 0;

	public UserServiceImpl() {
		System.out.println("UserServiceImpl initialized count = " + ctn);
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
	public List<User> selectUsersPageList(Page page) {
		return userDao.selectUsersPageList(page);
	}

	@Override
	public void deleteAndInsert(User user) {
		System.out.println("delete之前存在这条数据吗?");
		System.out.println(this.userDao.selectUser(user.getId()));
		this.userDao.deleteUser(user.getId());
		System.out.println("delete之后存在这条数据吗?");
		System.out.println(this.userDao.selectUser(user.getId()));
		this.userDao.addUser(user);
		System.out.println("插入之后存在这条数据吗?");
		System.out.println(this.userDao.selectUser(user.getId()));

	}

}
