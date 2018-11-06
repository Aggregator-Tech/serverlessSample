package sample.serverless.topic.cud.handler.impl;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.glassfish.hk2.api.Factory;
import org.jvnet.hk2.annotations.Service;

@Service
public class DynamoDBMapperService implements Factory<DynamoDBMapper> {

    @Override
    public DynamoDBMapper provide() {
        Regions region = Regions.fromName("us-east-2");
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                                .standard()
                                .withRegion(region)
                                .build();
        return new DynamoDBMapper(client);
    }

    @Override
    public void dispose(DynamoDBMapper instance) {

    }
}
