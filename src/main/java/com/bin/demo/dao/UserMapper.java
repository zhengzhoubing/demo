package com.bin.demo.dao;

import com.bin.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * package: com.bin.demo.dao
 * class: UserMapper
 * description: TODO用一句话描述该文件做什么
 * date 2020/1/15 15:42
 *
 * @author ZhengZhouBin
 **/
@Repository
public interface UserMapper {

    List<User> queryUser();

}
