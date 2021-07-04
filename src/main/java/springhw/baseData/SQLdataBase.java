package springhw.baseData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class SQLdataBase implements IBaseData{
	
	private final Integer MaxSize;
	private Map<Integer, Record> data = new TreeMap<Integer, Record>();

	public SQLdataBase() {
		MaxSize = 100;
		readBase();
	}
	
	@Override
	public Map<Integer, Record> getData() {
		return data;
	}
	
	@Override
	public void readBase() {
		String filePath = "E:\\Загрузки\\springhw-master"
				+ "\\src\\main\\java\\"
				+ "springhw\\baseData\\baseData.txt";
		File file = new File(filePath);
		
		try(Scanner scanner = new Scanner(file))
		{
			Integer curSize = scanner.nextInt();
			
			for (int i = 0; i < curSize; ++i) {
				Integer key; 
				Record value = new Record();
				
				key = scanner.nextInt();
				value.setName(scanner.next());
				value.setTopic(scanner.next());
				value.setAudienceNumber(scanner.nextInt());
				
				data.put(key, value);
			}
			
		}
		catch(IOException ex){
		    System.out.println(ex.getMessage());
		}
		
	}
	
	@Override
	public void update() {
		
		String filePath = "E:\\Загрузки\\springhw-master"
						+ "\\src\\main\\java\\"
						+ "springhw\\baseData\\baseData.txt";
		
		try(FileWriter writer = new FileWriter(filePath, false))
        {
			Iterator itr = data.entrySet().iterator();
			
			writer.write(data.size() + "\n");
			
			while (itr.hasNext()) {
				Entry entry = (Entry)itr.next();
				
				String key = ((Integer)entry.getKey()).toString();
				Record value = ((Record)entry.getValue());
				
				String textRecord = " " + value.getName() + 
									" " + value.getTopic() + 
									" " + value.getAudienceNumber() + "\n";
	            writer.write(key);
	            writer.write(textRecord);
	            
	            writer.flush();
			}
             
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
	}
	
	@Override
	public void pushBack(Integer id, Record record) {
		
		if (data.size() < MaxSize) {
			data.put(id, record);
			update();
		} else {
			System.out.println("База данных переполнена!!!");
		}
			
	}

	@Override
	public void pop(Integer id) {
		try {
			data.remove(id);
			update();
		} catch(NullPointerException  e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void changeRecord(Integer id, Record record) {
		try {
			data.remove(id);
			data.put(id, record);
			update();
		} catch(NullPointerException  e) {
			System.out.println(e.getMessage());
		}
	}

}
