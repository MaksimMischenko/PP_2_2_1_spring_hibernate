package hiber.dao;

import hiber.model.User;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@AllArgsConstructor
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getFromUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<User> getUserCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from User where car.series =:series and car.model =:model");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList();
    }
}
