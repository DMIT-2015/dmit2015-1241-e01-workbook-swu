package dmit2015.repository;

import dmit2015.entity.Location;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Short> {
}
