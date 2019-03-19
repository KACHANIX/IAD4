package ipm.customs.IAD4_BACKEND.Services;

import ipm.customs.IAD4_BACKEND.Entities.User;
import ipm.customs.IAD4_BACKEND.Entities.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userdao;

    public List<User> getUsers() {
        return this.userdao.findAll();
    }

    public User addUser(User user) {
        return this.userdao.save(user);
    }
     public User findUser(String username){
        return this.userdao.findByUsername(username).get();
     }
}