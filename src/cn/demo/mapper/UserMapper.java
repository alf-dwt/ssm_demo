package cn.demo.mapper;

import cn.demo.model.User;

public interface UserMapper {
	void insertUser(User user);
	User getUser(int id);
}
