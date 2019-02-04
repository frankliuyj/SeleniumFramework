package com.frank.selenium.utils.datasource;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoManager implements IDataSource {

	String dbName = "";
	String collectionName = "";

	JSONObject json = null;
	MongoClient mongoClient = null;
	MongoDatabase mongoDatabase = null;
	MongoCollection<Document> collection = null;

	public MongoManager(String dbName, String collectionName) {

		this.dbName = dbName;
		this.collectionName = collectionName;
	}

	private void initDBConnections(String DBName, String collectionName) {
		MongoClientURI connectionString = new MongoClientURI(
				"mongodb+srv://xinwang:123456abc*@db-mohet.azure.mongodb.net/");
		// MongoClientURI("mongodb://xinwang:123456abc*@db-shard-00-00-mohet.azure.mongodb.net:27017,db-shard-00-01-mohet.azure.mongodb.net:27017,db-shard-00-02-mohet.azure.mongodb.net:27017/test?ssl=true&replicaSet=db-shard-0&authSource=admin&retryWrites=true");
		mongoClient = new MongoClient(connectionString);
		mongoDatabase = mongoClient.getDatabase(DBName);
		collection = mongoDatabase.getCollection(collectionName);
		FindIterable<Document> findIterable = collection.find();
		if (findIterable.first() == null)
			initData();
	}

	private void stopDBConnections() {
		mongoClient.close();
		json = null;
		mongoClient = null;
		mongoDatabase = null;
		collection = null;
		System.gc();
	}

	private void initData() {

		Document document = new Document("password", "198112abc").append("wrong_username", "138")
				.append("wrong_password", "123456").append("url", "http: //mail.10086.cn/")
				.append("username", "1381003366").append("destination_keyword", "index.html?sid=");
		List<Document> documents = new ArrayList<Document>();
		documents.add(document);
		collection.insertMany(documents);
	}

	public String getProperty(String key) {

		initDBConnections(dbName, collectionName);

		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();

		String jsonString = "";
		if (mongoCursor.hasNext()) {
			Document doc = mongoCursor.next();
			jsonString = doc.toJson();
		}

		json = new JSONObject(jsonString);
		String value = json.getString(key);

		stopDBConnections();
		//System.out.println(value);
		return value;

	}

	public void writeNewProperty(String key, String value) {
		initDBConnections(dbName, collectionName);
		
		FindIterable<Document> findIterable = collection.find();
		Document doc = findIterable.first();
		if (doc != null) {
			doc.put(key, value);
			Bson filter = Filters.eq("_id", doc.get("_id"));
			collection.updateOne(filter, new Document("$set", doc));
		}

		stopDBConnections();

	}

	public static void main(String[] args) {

		MongoManager mongo = new MongoManager("third", "test");
		System.out.println(mongo.getProperty("url"));
		mongo.writeNewProperty("username", "13810033664");
	}

}
