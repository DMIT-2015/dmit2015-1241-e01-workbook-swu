package dmit2015.repository;

import dmit2015.entity.Department;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Short> {
}
