package springhw.mainMircoService;

import java.util.ArrayList;
import java.util.List;

import springhw.Users.IUser;
import springhw.baseData.IBaseData;
import springhw.baseData.Record;
import springhw.microService.IMessager;

public class Mediator {
	private IUser user;
	private IBaseData baseData;
	private List<IMessager> messagers;
	
	private Boolean answer;
	
	public Mediator() {
		answer = true;
	}
	
	public Mediator(IUser user, IBaseData baseData, List<IMessager> messagers) {
		super();
		this.user = user;
		this.baseData = baseData;
		this.messagers = messagers;
		answer = true;
	}
	//-----------------------------------------
	public IUser getUser() {
		return user;
	}
	public void setUser(IUser user) {

		this.user = user;
	}
	
	public IBaseData getBaseData() {
		return baseData;
	}
	public void setBaseData(IBaseData baseData) {
		this.baseData = baseData;
	}

	public List<IMessager> getMessagers() {
		return messagers;
	}
	public void setMessagers(List<IMessager> messagers) {
		this.messagers = messagers;
	}
	
	public String getAnswer() {
		return answer? "operation good" : "operation: bad";
	}
	
	//------------------------------------------
	public List<Record> getAllRecords() {
		return new ArrayList<Record>(baseData.getData().values());
	}
	
	public void pushRecord(Integer id, Record record) {
		baseData.pushBack(id, record);
	}
	
	public void popRecord(Integer id) {
		baseData.pop(id);
	}
	
	public void changeRecord(Integer id, Record record) {
		baseData.changeRecord(id, record);
	}
	//---------------------- рассылка по мессенжерам -----------------------
	public void sendAllMessagers() {
		for (IMessager i: messagers) {
			System.out.println("Сообщение:" + "\'" + i.getMessage() + "\'"+ "отправлено:\n" + 
					"в: " + i.getName() + "\n"); 
			
			i.sendAll();
		}
	}
}
