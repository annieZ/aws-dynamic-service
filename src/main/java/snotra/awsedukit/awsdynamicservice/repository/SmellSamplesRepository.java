package snotra.awsedukit.awsdynamicservice.repository;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import lombok.extern.slf4j.Slf4j;
import snotra.awsedukit.awsdynamicservice.config.DynamoDbConfiguration;
import snotra.awsedukit.awsdynamicservice.model.SmellSample;

@Repository
@Slf4j
public class SmellSamplesRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	@Autowired
	DynamoDbConfiguration dynamoDbConfiguration;
	
	@PostConstruct
	public void setupConfirm()
	{
		log.info("Database config: {}", dynamoDbConfiguration.toString());
	}
	public SmellSample save (SmellSample smellSample)
	{
		dynamoDBMapper.save(smellSample);
		return smellSample;
	}
	public SmellSample save(String smellType, long tvoc, long eCO2) {
		SmellSample sample = generateEmptySample();
		sample.setECO2(eCO2);
		sample.setTvoc(tvoc);
		sample.setSumittedSmellType(smellType);

		dynamoDBMapper.save(sample);
		return sample;
	}
	private SmellSample generateEmptySample() {
		SmellSample sample = new SmellSample();
		sample.setSubmissionDate(Date.from(Instant.now()));
		
		return sample;
	}
	public List<SmellSample> findByTvocAndECo2(long tvoc, long eCO2) {
		try {
			
			 Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		        eav.put(":val1", new AttributeValue().withN(String.valueOf(tvoc)));
		        eav.put(":val2", new AttributeValue().withN(String.valueOf(eCO2)));

			DynamoDBQueryExpression<SmellSample> queryExpression = new DynamoDBQueryExpression<SmellSample>()
		            .withKeyConditionExpression("tvoc = :val1 and eCO2 = :val2")
		            .withExpressionAttributeValues(eav);

			List<SmellSample> sampleList = dynamoDBMapper.query(SmellSample.class, queryExpression);
			if (sampleList != null && !sampleList.isEmpty())
			{	// for now just return first one
				return List.of(sampleList.get(0));
			}
			else {
				log.info("AZ, No samples found");
				return List.of( generateEmptySample());
			}
		}
		catch(Exception ex) {
			log.error(ex.getLocalizedMessage());
			return List.of( generateEmptySample());
		}
	}
	
}
