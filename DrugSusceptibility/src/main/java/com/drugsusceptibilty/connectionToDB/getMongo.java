package com.drugsusceptibilty.connectionToDB;

import java.io.FileNotFoundException;
import java.util.Scanner;
import com.drugsusceptibilty.ui.userQuestionnaire;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ReadConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.drugsusceptibilty.logic.*;


public class getMongo {
		public static void main(String[] args) throws FileNotFoundException {
		//Load data
		connectionToMongoDB connectMongo= new connectionToMongoDB();
		connectMongo.importData();
		//Take user input	
		userQuestionnaire questionnaire= new userQuestionnaire();
		questionnaire.printForm();		
	}
}
