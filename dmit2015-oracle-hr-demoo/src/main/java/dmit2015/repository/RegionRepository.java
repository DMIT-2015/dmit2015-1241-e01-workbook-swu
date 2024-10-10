package dmit2015.repository;

import dmit2015.entity.Region;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

}
