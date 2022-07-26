package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    public List<User> checkUser(String model, int series) {
        return userDao.checkUser(model, series);
    }

}
