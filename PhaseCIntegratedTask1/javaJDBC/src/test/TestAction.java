package test;

import java.util.List;

import action.UserAction;
import dao.User;

public class TestAction {
	public static void main(String[] args) {
		UserAction a=new UserAction();
		User u=new User();
		/*
		u.setId(23);
		u.setName("ղķ˹");
		u.setPassword("123456");
		u.setIntegral(10.0);
		a.update(u,5);
		*/
		
		List<User> l=a.query("");
		for (User user : l) {
			System.out.println(user.getId()+user.getName());
		}
		
		
	}
}
