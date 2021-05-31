package cn.itcast.login.userDao;

import cn.itcast.login.user.User;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.sql.Connection;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());

    public User login(User loginUser){
        try {
            String sql = "select * from user where userName = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUserName(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
