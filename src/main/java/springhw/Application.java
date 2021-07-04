package springhw;

import java.util.ArrayList;
import java.util.List;

import springhw.Users.IUser;
import springhw.Users.RegisteredUser;
import springhw.Users.UnRegisteredUser;
import springhw.baseData.IBaseData;
import springhw.baseData.Record;
import springhw.baseData.SQLdataBase;
import springhw.mainMircoService.Mediator;
import springhw.microService.Email;
import springhw.microService.IMessager;
import springhw.microService.Telegram;

public class Application {

	public static void main(String[] args) {
		//IUser user = new UnRegisteredUser();
		IUser user = new RegisteredUser("Евгений", "Бубнов");
		
		Record rec1 = new Record("Evgeny", "Practica", 5214);
		Record rec2 = new Record("Tanya", "Practica", 5215);
		Record rec3 = new Record("Vova", "Practica", 5216);
		Record rec4 = new Record("Roma", "Practica", 5217);
		
		user.pushRecord(rec1.hashCode(), rec1);
		user.pushRecord(rec2.hashCode(), rec2);
		user.pushRecord(rec3.hashCode(), rec3);
		user.pushRecord(rec4.hashCode(), rec4);
		//--------------------------------------------
		
		List<IMessager> messagers = new ArrayList<IMessager>();
		messagers.add(new Telegram());
		messagers.add(new Email());
		
		IBaseData sqlData = new SQLdataBase();
		
		Mediator mediator = new Mediator(user, sqlData, messagers);
		
		for (int i = 1; i <= user.getRecords().size(); ++i) {
			mediator.pushRecord(user.getRecord(i).getId(), user.getRecord(i).getRecord());
			System.out.println(mediator.getAnswer());
		} 
	}
	
	
	public static void testPushRocords() {
		IUser user = new RegisteredUser("Евгений", "Бубнов");
		
		Record rec1 = new Record("Evgeny", "Practica", 5214);
		Record rec2 = new Record("Tanya", "Practica", 5215);
		Record rec3 = new Record("Vova", "Practica", 5216);
		Record rec4 = new Record("Roma", "Practica", 5217);
		
		user.pushRecord(rec1.hashCode(), rec1);
		user.pushRecord(rec2.hashCode(), rec2);
		user.pushRecord(rec3.hashCode(), rec3);
		user.pushRecord(rec4.hashCode(), rec4);
		//--------------------------------------------
		
		List<IMessager> messagers = new ArrayList<IMessager>();
		messagers.add(new Telegram());
		messagers.add(new Email());
		
		IBaseData sqlData = new SQLdataBase();
		
		Mediator mediator = new Mediator(user, sqlData, messagers);
		
		for (int i = 1; i <= user.getRecords().size(); ++i) {
			mediator.pushRecord(user.getRecord(i).getId(), user.getRecord(i).getRecord());
			System.out.println(mediator.getAnswer());
		} 
	}
	
	public static void testPopRocords() {
		
	}
	
	public static void testChangeRocords() {
		
	}
}

