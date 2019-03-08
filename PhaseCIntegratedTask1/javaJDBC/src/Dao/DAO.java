package Dao;

import java.util.List;

public interface DAO {
	public void add(User u);
	public void delete(int u);
	public void update(User u);
	public List<User> query(String u);
	public int queryCount();
	
}
