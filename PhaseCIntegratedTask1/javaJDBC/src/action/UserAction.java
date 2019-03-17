package action;

import java.util.List;

import dao.DAO;
import dao.User;
import dao.UserDao;

public class UserAction {
	public void add(User user) {
		DAO d=new UserDao();
		d.add(user);
	}
	
	public void delete(int id) {
		DAO d=new UserDao();
		d.delete(id);
	}
	
	public void update(User user,String name) {
		DAO d=new UserDao();
		d.update(user,name);
	}
	
	public List<User> query(String name){
		DAO d=new UserDao();
		return d.query(name);
	}
	
	public int queryCount() {
		DAO d=new UserDao();
		return d.queryCount();
	}

}
