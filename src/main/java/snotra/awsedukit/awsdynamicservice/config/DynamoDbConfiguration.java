package snotra.awsedukit.awsdynamicservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Data
@Slf4j
public class DynamoDbConfiguration {
	
	
	@Value("${amazon.dynamodb.endpoint}")
	private String amazonDynamoDBEndpoint;

	@Value("${amazon.aws.accesskey}")
	private String amazonAWSAccessKey;

	@Value("${amazon.aws.secretkey}")
	private String amazonAWSSecretKey;
	
	@Value("${amazon.aws.region}")
	private String amazonAWSRegion;


	
	private AmazonDynamoDB amazonDynamoDB;
	
	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynameDB());
	}

	private AmazonDynamoDB buildAmazonDynameDB() {
		log.info("AZ: region and accesskey : {}, {}", amazonAWSRegion, amazonAWSAccessKey);
		
		amazonDynamoDB = AmazonDynamoDBClientBuilder
				.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
								amazonDynamoDBEndpoint, 
								amazonAWSRegion))
				.withCredentials(
						new AWSStaticCredentialsProvider (
							new BasicAWSCredentials(
									amazonAWSAccessKey, 
									amazonAWSSecretKey
									)
							)
					)
				.build();
		return amazonDynamoDB;
	}
}
