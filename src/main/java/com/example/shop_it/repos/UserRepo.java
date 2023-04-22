package com.example.shop_it.repos;

import com.example.shop_it.models.ItemModel;
import com.example.shop_it.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByName(String name);
    UserModel findByLoginAndPassword(String login, String password);
}
