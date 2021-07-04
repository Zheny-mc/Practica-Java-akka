package springhw.microService;

import java.util.ArrayList;

import springhw.Users.IUser;
import springhw.Users.RegisteredUser;

public class Telegram extends IMessager {
	
	public Telegram() {
		name = "Telegram";
		users = new ArrayList<IUser>();
		users.add(new RegisteredUser("Евгений", "Бубнов"));
		users.add(new RegisteredUser("Вова", "Смолков"));
	}
	
	@Override
	public void sendAll() {
		for (IUser i: users) {
			System.out.println("Сообщение:" + "\'" + message + "\'" + "отправлено:\n" + 
					"от:" + sender + "\n" +  "к: "+ i.getName() + " " + i.getSurname() +"\n"); 
		}
	}
}
