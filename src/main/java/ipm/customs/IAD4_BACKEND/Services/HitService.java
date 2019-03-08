package ipm.customs.IAD4_BACKEND.Services;

import ipm.customs.IAD4_BACKEND.Entities.Hit;
import ipm.customs.IAD4_BACKEND.Entities.HitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HitService {
    @Autowired
    HitDao hitdao;

    public List<Hit> getHits() {
        return this.hitdao.findAll();
    }

    public Hit addHit(Hit hit) {
        return this.hitdao.save(hit);
    }
}
