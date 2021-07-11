package snotra.awsedukit.awsdynamicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import snotra.awsedukit.awsdynamicservice.SampleIdentification;
import snotra.awsedukit.awsdynamicservice.model.SmellSample;
import snotra.awsedukit.awsdynamicservice.repository.SmellSamplesRepository;

@RestController
public class SmellSamplesController {
	
	@Autowired
	private SmellSamplesRepository smellSamplesRepository;
	
	@Autowired
	private SampleIdentification sampleIdentification;
	
	@PostMapping("/submitSample")
	public SmellSample saveSample(@RequestBody SmellSample smell)
	{
		return smellSamplesRepository.save(smell);
	}
	
	@PostMapping("/identifySample")
	public SmellSample identifySample(@RequestBody SmellSample smell)
	{
		return sampleIdentification.identifySample(smell);
	}

}
