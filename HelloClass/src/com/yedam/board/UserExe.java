package com.yedam.board;

/*
 * User: 아이디, 비밀번호, 이름
 * 
 */
class User {
	private String userId;
	private String passwd;
	private String userName;

	public User(String userId, String passwd, String userName) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

// getter
	public String getUserId() {
		return userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getUserName() {
		return userName;
	}

}

public class UserExe {
	static User[] users = { //
			new User("holy", "1111", "김영광")//
			, new User("cutie", "2222", "홍예쁨")//
			, new User("guest", "3333", "밤손님")//
	};
	// 사용자 아이디, 비밀번호 매개값으로...
	static boolean login(String uname, String passwd) {
		for (User user : users) {
			if (user.getUserId().equals(uname) && user.getPasswd().equals(passwd)) {
				return true;
			}
		}
		return false;
	}
}
