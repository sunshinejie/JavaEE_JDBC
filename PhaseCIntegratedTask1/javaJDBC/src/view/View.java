package view;

import java.util.List;
import java.util.Scanner;

import action.UserAction;
import dao.User;

public class View {
	
	private static final String CONTEXT="欢迎来到控制台：\n"+
										"下面是数据库控制台的操作指南：\n"+
										"[MAIN/M]：操作首页\n"+
										"[ADD/A]:添加用户信息\n"+
										"[DELETE/D]:删除用户信息\n"+
										"[UPDATE/U]:更新用户信息\n"+
										"[QUERY/Q]:查询用户信息\n"+
										"[USERCOUNT/C]:查询用户总数\n"+
										"[EXIT/E]:退出控制台";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_USERCOUNT="COUNT";
	private static final String OPERATION_EXIT="EXIT";
	
	public static void main(String[] args) {
		
		System.out.println(CONTEXT);
		
		Scanner scanner=new Scanner(System.in);
		User user=new User();
		UserAction userAction=new UserAction();
		String previous=null;
		Integer step=1;
		Integer step2=1;
		Integer step3=1;
		while(scanner.hasNext()) {
			
			String in=scanner.next().toString();
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
				System.out.println("你已经成功退出控制台！");
				break;
				
			}
			
			/*if(OPERATION_MAIN.equals(in.toUpperCase())
					||OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())) {
				if(1==1) {
					System.out.println("已经返回控制台，请继续操作！");
					continue;
				}
			
			}*/
			else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_QUERY.equals(previous)) {
				previous=OPERATION_QUERY;
				if(step2==1) {
					System.out.println("请输入要查询的用户姓名：");
				}else if(step2==2) {
					try {
						List<User> list=userAction.query(in);
						for (User user2 : list) {
							System.out.println(user2.toString());
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}if(OPERATION_QUERY.equals(previous)) {
					step2++;
				}
				
			}/*if(OPERATION_UPDATE.equals(in.toUpperCase())
					||OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_UPDATE.equals(previous))
				previous=OPERATION_UPDATE;
				if(step3==1) {
					System.out.println("请修改用户的id:");
				}else if(step3==2) {
					user.setId(Integer.valueOf(in));
					System.out.println("请修改用户的姓名：");
				}else if(step3==3) {
					user.setName(in);
					System.out.println("请修改用户的密码：");
				}else if(step3==4) {
					user.setPassword(in);
					System.out.println("请修改用户的积分：");
				}else if(step3==5) {
					user.setIntegral(Double.valueOf(in));
					System.out.println("你要对哪个用户进行这些修改，请输入用户名：");
				}else if(step3==6) {
					String name=in;
					try {
						userAction.update(user, name);
						System.out.println("更新成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}if(OPERATION_UPDATE.equals(previous)) {
					step3++;
				}
				*/
	
			/*else if(OPERATION_DELETE.equals(in.toUpperCase())
					||OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_DELETE.equals(previous)) {
				previous=OPERATION_DELETE;
				step=1;
				if(step==1) {
					System.out.println("请输入要删除用户的id:");
				}else if(step==2) {
					try {
						userAction.delete(10);
						System.out.println("id为‘"+in+"’的用户已经从数据库删除！");
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("删除失败！");
					}
				}else if(OPERATION_DELETE.equals(previous)) {
					step++;
				}
				*/
			else if(OPERATION_USERCOUNT.equals(in.toUpperCase())
					||OPERATION_USERCOUNT.substring(0, 1).equals(in.toUpperCase())) {
				int n=userAction.queryCount();
				System.out.println("用户的总数是:"+n);
				
			}else if(OPERATION_ADD.equals(in.toUpperCase())			
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(previous)) {
				
				previous=OPERATION_ADD;
				
				if(step==1) {
					System.out.println("请输入用户的id：");
				}else if(step==2) {
					user.setId(Integer.valueOf(in));
					System.out.println("请输入用户的姓名：");
				}else if(step==3) {
					user.setName(in);
					System.out.println("请输入用户的密码：");
				}else if(step==4) {
					user.setPassword(in);
					System.out.println("请输入用户的积分：");
				}else if(step==5) {
					user.setIntegral(Double.valueOf(in));
					
					try {
						userAction.add(user);
						System.out.println("新增用户成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("新增用户失败");
					}
					
				}if(OPERATION_ADD.equals(previous)){
					step++;
				}	
			}
		}
		
		
	}

}
