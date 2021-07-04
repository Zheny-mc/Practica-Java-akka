package springhw.microService;

import java.util.List;

import springhw.Users.IUser;

public abstract class IMessager {
	protected String name;
	protected String message;
	protected String sender;
	protected List<IUser> users;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public List<IUser> getUsers() {
		return users;
	}
	public void setUsers(List<IUser> users) {
		this.users = users;
	}

	public abstract void sendAll();
}
