package ipm.customs.IAD4_BACKEND.Controller;

import ipm.customs.IAD4_BACKEND.Entities.Hit;
import ipm.customs.IAD4_BACKEND.Entities.User;
import ipm.customs.IAD4_BACKEND.Services.AreaChecker;
import ipm.customs.IAD4_BACKEND.Services.Encryptor;
import ipm.customs.IAD4_BACKEND.Services.HitService;
import ipm.customs.IAD4_BACKEND.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    @CrossOrigin

    @RequestMapping(value = "/all_users", method = RequestMethod.GET)
    public List<User> getUsers() {
        for (User usr : userService.getUsers()) {
            usr.password = Encryptor.decrypt(usr.password);
        }
        return userService.getUsers();
    }

    @CrossOrigin
    @RequestMapping(value = "/add_user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public boolean newUser(@RequestBody User user) {
        boolean answer = true;
        user.password = Encryptor.encrypt(user.password);
        for (User usr : userService.getUsers()) {
            System.out.println(usr.password + "   " + usr.username + "\n" + user.password + "   " + user.username);
            if (user.username.equals(usr.username)) {
                answer = false;
            }
        }
        if (answer) {
            userService.addUser(user);
            return true;
        } else {
            return false;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/all_hits", method = RequestMethod.GET)
    public List<Hit> getHits() {
        return hitService.getHits();
    }

    @CrossOrigin
    @RequestMapping(value = "/add_hit/{username}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public Hit newHit(@RequestBody Hit hit, @PathVariable String username) {
        hit.hit_time = new Timestamp(System.currentTimeMillis()).toString();
        hit.answer = areaChecker.Check(hit.x, hit.y, hit.r);
        hit.uUsr = userService.findUser(username);
        return hitService.addHit(hit);
    }

    @CrossOrigin
    @RequestMapping(value = "/user_hits/{username}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hit> userHits(@PathVariable String username){
        return hitService.getHitsByUser(userService.findUser(username));
    }

    @CrossOrigin
    @RequestMapping(value = "/check_user", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public boolean checkUser(@RequestBody User user) {
        boolean answer = false;
        for (User usr : userService.getUsers()) {
            usr.password = Encryptor.decrypt(usr.password);
            System.out.println(usr.password + "   " + usr.username + "\n" + user.password + "   " + user.username);
            if (user.username.equals(usr.username) && user.password.equals(usr.password)) {
                answer = true;
            }
        }
        System.out.println(answer);
        return answer;
    }

}
