package money.master.backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {
    private MongoClient   mongoClient;
    private MongoDatabase database;
    
    public MongoConnector() {
        mongoClient = MongoClients.create(
                "mongodb+srv://mongoUser:dbUserPassword@moneymaster-ye060.mongodb.net/test?retryWrites=true&w=majority");
        database    = mongoClient.getDatabase("test");
    }
    
    
}
