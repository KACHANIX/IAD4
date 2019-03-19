package ipm.customs.IAD4_BACKEND.Entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HitDao extends JpaRepository<Hit, Integer> {
    public List<Hit> findAllByUUsr(User user);
}
