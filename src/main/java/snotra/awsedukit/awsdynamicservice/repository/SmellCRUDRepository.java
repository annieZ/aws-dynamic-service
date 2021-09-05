package snotra.awsedukit.awsdynamicservice.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import snotra.awsedukit.awsdynamicservice.model.SmellSample;

@EnableScan
@Repository
public interface SmellCRUDRepository extends CrudRepository<SmellSample, String> {

	List<SmellSample> findByTvocAndECo2(long tvoc, long eCO2);
}
