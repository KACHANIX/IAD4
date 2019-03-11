package ipm.customs.IAD4_BACKEND.Controller;

import ipm.customs.IAD4_BACKEND.Entities.Hit;
import ipm.customs.IAD4_BACKEND.Entities.User;
import ipm.customs.IAD4_BACKEND.Services.AreaChecker;
import ipm.customs.IAD4_BACKEND.Services.Encryptor;
import ipm.customs.IAD4_BACKEND.Services.HitService;
import ipm.customs.IAD4_BACKEND.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    HitService hitService;

    @Autowired
    UserService userService;

    @Autowired
    AreaChecker areaChecker;


    @RequestMapping(value = "/all_users", method = RequestMethod.GET)
    public List<User> getUsers() {
        for (User usr : userService.getUsers()){
            usr.password = Encryptor.decrypt(usr.password);
        }
        return userService.getUsers();
    }


    @RequestMapping(value = "/add_user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public User newUser(@RequestBody User user) {
        user.password = Encryptor.encrypt(user.password);
        System.out.println(user.password);
//        return user;
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all_hits", method = RequestMethod.GET)
    public List<Hit> getHits() {
        return hitService.getHits();
    }


    @RequestMapping(value = "/add_hit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Hit newHit(@RequestBody Hit hit) {
        hit.hit_time = new Timestamp(System.currentTimeMillis()).toString();
        hit.answer = areaChecker.Check(hit.x, hit.y, hit.r);

        return hitService.addHit(hit);
    }


}
