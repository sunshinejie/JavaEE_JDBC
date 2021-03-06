package dao;

import java.util.List;

public interface DAO {
	public void add(User user);
	public void delete(int id);
	public void update(User user,String name);
	public List<User> query(String name);
	public int queryCount();
}
