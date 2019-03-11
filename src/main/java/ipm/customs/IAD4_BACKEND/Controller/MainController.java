package ipm.customs.IAD4_BACKEND.Controller;

import ipm.customs.IAD4_BACKEND.Entities.Hit;
import ipm.customs.IAD4_BACKEND.Services.HitService;
import ipm.customs.IAD4_BACKEND.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    HitService hitService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/all_hits", method = RequestMethod.GET)
    public List<Hit> getHits() {
        return hitService.getHits();
    }


    @RequestMapping(value = "/add_hit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Hit newHit(@RequestBody Hit hit) {

        return hitService.addHit(hit);
    }


}
