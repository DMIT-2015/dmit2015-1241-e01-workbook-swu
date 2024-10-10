package dmit2015.repository;

import dmit2015.entity.Country;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
}
