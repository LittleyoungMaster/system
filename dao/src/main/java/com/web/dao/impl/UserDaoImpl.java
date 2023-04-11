package com.web.dao.impl;

import com.web.dao.User;
import com.web.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<Object> getUser() {
        List<Object> selectBlog=null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession = build.openSession();

            selectBlog = sqlSession.selectList("selectBlog");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectBlog;
    }

}
