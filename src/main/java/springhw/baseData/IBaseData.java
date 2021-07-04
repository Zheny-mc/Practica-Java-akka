package springhw.baseData;

import java.util.Map;

public interface IBaseData {
	public void pushBack(Integer id, Record record); //(.....)
	public void pop(Integer id);
	public void changeRecord(Integer id, Record record);
	public void readBase();
	public void update();
	public Map<Integer, Record> getData();
}
