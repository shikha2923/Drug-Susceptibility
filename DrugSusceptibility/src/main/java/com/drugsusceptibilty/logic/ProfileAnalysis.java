package com.drugsusceptibilty.logic;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class ProfileAnalysis extends BasicDBObject{
public static int counttotal = 0;
public static int count = 0;

public static void findAddiction(String gender, String education, String Age) {
//drugs under test
String[] drugsTested = {"Alcohol consumption","Cannabis consumption","Cocaine consumption", "Caffiene consumption", "Nicotine consumption"};

//Create Connection
MongoClient databaseClient = new MongoClient("127.0.0.1", 27017);
MongoDatabase db = databaseClient.getDatabase("DrugSusceptibility");
MongoCollection<Document> dbcoll = db.getCollection("TestDrugs");

//Define testing parameters
Bson filter = Filters.eq("Education");
Bson filter2 = Filters.eq("Gender");
Bson filter4 = Filters.eq("Age");

//For each drug to be tested
for(int i = 0; i<drugsTested.length; i++) {
	Bson filter3 = Filters.eq(drugsTested[i]);
	String[] fieldnames= {"Education","Gender", "Age",drugsTested[i]};
	Block<Document> printBlock = new Block<Document>() {
		
	    @Override
	    public void apply(final Document document) {
	        System.out.println(document.toJson());
	    }
	};

	dbcoll.find(filter).forEach(printBlock);
	BasicDBObject inQuery = new BasicDBObject();
	List<String> list = new ArrayList<String>();
	//list.add("CL3");
	list.add("CL4");
	list.add("CL5");
	list.add("CL6");
	inQuery.put(drugsTested[i], new BasicDBObject("$in", list));

	BasicDBObject andQuery = new BasicDBObject();
	List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
	obj.add(new BasicDBObject("Education", education));
	obj.add(new BasicDBObject("Gender", gender));
	obj.add(new BasicDBObject("Age", Age));

	andQuery.put("$and", obj);
	FindIterable<Document> iterableTotal = dbcoll.find(andQuery).projection(Projections.include(fieldnames));
	BasicDBObject finalQuery = new BasicDBObject();
	List<BasicDBObject> listed = new ArrayList<BasicDBObject>();
	listed.add(andQuery);
	listed.add(inQuery);
	finalQuery.put("$and", listed);
	FindIterable<Document> iterableSelected = dbcoll.find(finalQuery).projection(Projections.include(fieldnames));
	iterableTotal.forEach(new Block<Document>() {
		
	    @Override
	    public void apply(final Document document) {
	    	counttotal++;
	    }   
	});

	iterableSelected.forEach(new Block<Document>() {
	    @Override
	    public void apply(final Document document) {
	    	count++;
	    }  
	});

	ProfileAnalysis profileAnalysis=new ProfileAnalysis();
	profileAnalysis.makeDecision(counttotal, count, drugsTested[i]);
	}	
}

public void makeDecision(int counttotal, int count, String drug) {
	System.out.println("Count total: "+ counttotal + "!!"+" Count: "+count);
	int c=2*(counttotal/5);
	if (count>=c) {
		System.out.println("Warning! Susceptible to "+ drug + "!!");
	}else {
		System.out.println("Congrats! not Susceptible to "+drug);
	}
}
}