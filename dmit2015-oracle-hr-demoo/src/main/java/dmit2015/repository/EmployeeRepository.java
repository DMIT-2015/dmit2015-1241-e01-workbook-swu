package dmit2015.repository;

import dmit2015.entity.Employee;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
