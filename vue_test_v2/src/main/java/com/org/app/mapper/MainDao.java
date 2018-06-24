package com.org.app.mapper;

import java.util.List;
import com.org.app.vo.User;

public interface MainDao {
	public List<User> getUserList () throws Exception;
}
