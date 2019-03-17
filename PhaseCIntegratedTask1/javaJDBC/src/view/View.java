package view;

import java.util.List;
import java.util.Scanner;

import action.UserAction;
import dao.User;

public class View {
	
	private static final String CONTEXT="��ӭ��������̨��\n"+
										"���������ݿ����̨�Ĳ���ָ�ϣ�\n"+
										"[MAIN/M]��������ҳ\n"+
										"[ADD/A]:�����û���Ϣ\n"+
										"[DELETE/D]:ɾ���û���Ϣ\n"+
										"[UPDATE/U]:�����û���Ϣ\n"+
										"[QUERY/Q]:��ѯ�û���Ϣ\n"+
										"[USERCOUNT/C]:��ѯ�û�����\n"+
										"[EXIT/E]:�˳�����̨";
	
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
				System.out.println("���Ѿ��ɹ��˳�����̨��");
				break;
				
			}
			
			/*if(OPERATION_MAIN.equals(in.toUpperCase())
					||OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())) {
				if(1==1) {
					System.out.println("�Ѿ����ؿ���̨�������������");
					continue;
				}
			
			}*/
			else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_QUERY.equals(previous)) {
				previous=OPERATION_QUERY;
				if(step2==1) {
					System.out.println("������Ҫ��ѯ���û�������");
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
					System.out.println("���޸��û���id:");
				}else if(step3==2) {
					user.setId(Integer.valueOf(in));
					System.out.println("���޸��û���������");
				}else if(step3==3) {
					user.setName(in);
					System.out.println("���޸��û������룺");
				}else if(step3==4) {
					user.setPassword(in);
					System.out.println("���޸��û��Ļ��֣�");
				}else if(step3==5) {
					user.setIntegral(Double.valueOf(in));
					System.out.println("��Ҫ���ĸ��û�������Щ�޸ģ��������û�����");
				}else if(step3==6) {
					String name=in;
					try {
						userAction.update(user, name);
						System.out.println("���³ɹ�");
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
					System.out.println("������Ҫɾ���û���id:");
				}else if(step==2) {
					try {
						userAction.delete(10);
						System.out.println("idΪ��"+in+"�����û��Ѿ������ݿ�ɾ����");
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("ɾ��ʧ�ܣ�");
					}
				}else if(OPERATION_DELETE.equals(previous)) {
					step++;
				}
				*/
			else if(OPERATION_USERCOUNT.equals(in.toUpperCase())
					||OPERATION_USERCOUNT.substring(0, 1).equals(in.toUpperCase())) {
				int n=userAction.queryCount();
				System.out.println("�û���������:"+n);
				
			}else if(OPERATION_ADD.equals(in.toUpperCase())			
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(previous)) {
				
				previous=OPERATION_ADD;
				
				if(step==1) {
					System.out.println("�������û���id��");
				}else if(step==2) {
					user.setId(Integer.valueOf(in));
					System.out.println("�������û���������");
				}else if(step==3) {
					user.setName(in);
					System.out.println("�������û������룺");
				}else if(step==4) {
					user.setPassword(in);
					System.out.println("�������û��Ļ��֣�");
				}else if(step==5) {
					user.setIntegral(Double.valueOf(in));
					
					try {
						userAction.add(user);
						System.out.println("�����û��ɹ�");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("�����û�ʧ��");
					}
					
				}if(OPERATION_ADD.equals(previous)){
					step++;
				}	
			}
		}
		
		
	}

}