package dmit2015.repository;

import dmit2015.entity.Job;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, String> {

}
