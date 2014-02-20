import com.tr.SpringMongoConfig;
import com.tr.entity.User;
import com.tr.repository.UserRepository;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMongoConfig.class)
public class UserRepositoryTest {

    @Autowired private UserRepository repository;

    private String firstName = "sample";
    private String lastName = "user";
    private User user = new User(firstName, lastName);

    @Before
    public void cleanUp() {
        repository.deleteAll();
        repository.save(user);
    }

    @Test
    public void canFindAll() {
        List<User> userList = repository.findAll();
        assertNotNull(userList);
        assertFalse(userList.isEmpty());
        assertEquals(1, userList.size());
        assertEquals(userList.get(0), user);
    }

    @Test
    public void canFindByFirstName() {
        User userRetrieved = repository.findByFirstName(firstName);

        assertNotNull(userRetrieved);
        assertEquals(user, userRetrieved);
    }

    @Test
    public void canFindByLastName() {
        List<User> users = repository.findByLastName(lastName);

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }
}
