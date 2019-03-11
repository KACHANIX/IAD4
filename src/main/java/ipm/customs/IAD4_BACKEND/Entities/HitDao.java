package ipm.customs.IAD4_BACKEND.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HitDao extends JpaRepository<Hit, Integer> {
}
