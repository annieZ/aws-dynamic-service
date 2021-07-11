package snotra.awsedukit.awsdynamicservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import snotra.awsedukit.awsdynamicservice.model.SmellSample;
import snotra.awsedukit.awsdynamicservice.repository.SmellSamplesRepository;

@Service
public class SampleIdentification {

	@Autowired
	private SmellSamplesRepository smellSamplesRepository;
	
	public SmellSample identifySample(SmellSample smell)
	{
		// TODO Fancy AI here
		return  new SmellSample();
	}
}
