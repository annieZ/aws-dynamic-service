package snotra.awsedukit.awsdynamicservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfiguration {

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynameDB());
	}

	private AmazonDynamoDB buildAmazonDynameDB() {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
								"dynamodb.us-east-1.amazonaws.com", 
								"us-east-1"))
				.withCredentials(
						new AWSStaticCredentialsProvider (
							new BasicAWSCredentials(
									"AKIAXDKMFQ32XQ5DHMHR", 
									"ZJ+Um0B2zeyshST/uRiEmuepRo0u42EWaI/LReth"
									)
							)
					)
				.build();
	}
}
