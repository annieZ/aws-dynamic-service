package snotra.awsedukit.awsdynamicservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DynamoDBDocument
public class GeoIP {
	@DynamoDBAttribute
	private String ipAddress;

	@DynamoDBAttribute
	private String city;

	@DynamoDBAttribute
	private String latitude;

	@DynamoDBAttribute
	private String longitude;
}
