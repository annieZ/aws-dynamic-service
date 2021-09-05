package snotra.awsedukit.awsdynamicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/submitSample/{smellType}/{tvoc}/{eCO2}")
	public SmellSample saveSample(@PathVariable String smellType, @PathVariable long tvoc, @PathVariable long eCO2)
	{
		log.info("AZ, Sample sumitted");
		return smellSamplesRepository.save(smellType, tvoc, eCO2);
	}
	
	@PostMapping("/identifySample")
	public SmellSample identifySample(@RequestBody SmellSample smell)
	{
		log.info("AZ, sample identification requested");
		return sampleIdentification.identifySample(smell);
	}
	@PostMapping("/identifySample/{tvoc}/{eCO2}")
	public SmellSample identifySample(@PathVariable long tvoc, @PathVariable long eCO2)
	{
		log.info("AZ, Sample sumitted");
		return sampleIdentification.identifySample(tvoc, eCO2);
	}

}
