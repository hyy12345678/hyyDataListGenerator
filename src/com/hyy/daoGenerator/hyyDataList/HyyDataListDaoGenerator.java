package com.hyy.daoGenerator.hyyDataList;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class HyyDataListDaoGenerator {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		Schema schema = new Schema(1, "com.hyy.hyydatalist.generator");
//		addMessage(schema);
//		addAlarm(schema);
		
		addMessageAndAlarm(schema);
		
		new DaoGenerator().generateAll(schema, "../hyyDataList/src-gen");
	}

	
	private static void addMessageAndAlarm(Schema schema){
		
		//Entity for message
		Entity messages = schema.addEntity("Messages");
		messages.addIdProperty();
		messages.addStringProperty("title");
		messages.addStringProperty("shortcut");
		messages.addStringProperty("content");
		messages.addStringProperty("alarmstatus").getProperty();
		
		//Entity for alarm
		Entity alarms = schema.addEntity("Alarms");
		alarms.addIdProperty();
		alarms.addStringProperty("alarmtime");
		alarms.addStringProperty("dayofweek");
//		alarms.addStringProperty("messageid");
		Property messageIdProperty = alarms.addLongProperty("messageid").getProperty();
		alarms.addToOne(messages, messageIdProperty);
		
		alarms.addStringProperty("ispause");
		
	}
	
	// private static void addMessage(Schema schema) {
	// // TODO Auto-generated method stub
	// Entity messages = schema.addEntity("Messages");
	// messages.addIdProperty();
	// messages.addStringProperty("title");
	// messages.addStringProperty("shortcut");
	// messages.addStringProperty("content");
	// messages.addStringProperty("alarmstatus").getProperty();
	//
	// }
	//
	// private static void addAlarm(Schema schema) {
	// // TODO Auto-generated method stub
	// Entity alarms = schema.addEntity("Alarms");
	// alarms.addIdProperty();
	// alarms.addStringProperty("alarmtime");
	// alarms.addStringProperty("dayofweek");
	// alarms.addStringProperty("messageid");
	// alarms.addStringProperty("ispause");
	//
	//
	// }


}
