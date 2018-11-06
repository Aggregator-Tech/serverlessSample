package sample.serverless.topic.object;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "topics")
public class Topic {

    private String spaceId;
    private String topicId;
    private String topicTitle;
    private String topicContent;

    public Topic(String spaceId, String topicTitle, String topicContent) {
        this.spaceId = spaceId;
        this.topicTitle = topicTitle;
        this.topicContent = topicContent;
    }

    public Topic(String topicId, String spaceId, String topicTitle, String topicContent) {
        this(spaceId, topicTitle, topicContent);
        this.topicId = topicId;
    }

    public Topic() {

    }

    @DynamoDBAttribute
    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    @DynamoDBHashKey(attributeName="topicId")
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @DynamoDBAttribute
    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    @DynamoDBAttribute
    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }
}
