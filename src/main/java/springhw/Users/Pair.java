package springhw.Users;

import springhw.baseData.Record;

public class Pair {
	private Integer id;
	private Record record;
	
	public Pair(Integer id, Record record) {
		super();
		this.id = id;
		this.record = record;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Record getRecord() {
		return record;
	}


	public void setRecord(Record record) {
		this.record = record;
	}



}
