package snotra.awsedukit.awsdynamicservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import snotra.awsedukit.awsdynamicservice.model.SmellSample;

@Repository
public class SmellSamplesRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public SmellSample save (SmellSample smellSample)
	{
		dynamoDBMapper.save(smellSample);
		return smellSample;
	}
	

}
