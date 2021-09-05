package snotra.awsedukit.awsdynamicservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import snotra.awsedukit.awsdynamicservice.model.SmellSample;
import snotra.awsedukit.awsdynamicservice.repository.SmellCRUDRepository;

@Service
@Slf4j
public class SampleIdentification {
	
	@Autowired SmellCRUDRepository smellCRUDRepository;
	
	public SmellSample identifySample(SmellSample smell)
	{
		// TODO Fancy AI here in the future with more parameters into account
		return  new SmellSample();
	}

	public SmellSample identifySample( long tvoc, long eCO2) {
		try {
			List<SmellSample> sampleList =  smellCRUDRepository.findByTvocAndECo2(tvoc, eCO2);
			if (sampleList != null && !sampleList.isEmpty())
			{
				// for prototype return just first one
				return sampleList.get(0);
			}
			else {
				log.info("NO Sample identified");
				return new SmellSample();
			}
		}
		catch(Exception ex)
		{
			log.error("AZ, error: {}", ex.getMessage());
			return new SmellSample();
		}
	}
}
