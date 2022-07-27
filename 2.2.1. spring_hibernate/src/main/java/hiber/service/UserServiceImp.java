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

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getFromUsers() {
        return userDao.getFromUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserCar(String model, int series) {
        return userDao.getUserCar(model, series);
    }

}
