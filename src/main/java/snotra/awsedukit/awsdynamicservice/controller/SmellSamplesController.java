package snotra.awsedukit.awsdynamicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import snotra.awsedukit.awsdynamicservice.SampleIdentification;
import snotra.awsedukit.awsdynamicservice.model.SmellSample;
import snotra.awsedukit.awsdynamicservice.repository.SmellSamplesRepository;

@RestController
@Slf4j
public class SmellSamplesController {
	
	@Autowired
	private SmellSamplesRepository smellSamplesRepository;
	
	@Autowired
	private SampleIdentification sampleIdentification;
	
	@PostMapping("/submitSample")
	public SmellSample saveSample(@RequestBody SmellSample smell)
	{
		log.info("AZ, Sample sumitted");
		return smellSamplesRepository.save(smell);
	}
	
	@PostMapping("/identifySample")
	public SmellSample identifySample(@RequestBody SmellSample smell)
	{
		log.info("AZ, sample identification requested");
		return sampleIdentification.identifySample(smell);
	}

}
