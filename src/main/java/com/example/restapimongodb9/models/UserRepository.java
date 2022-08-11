package com.example.restapimongodb9.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>
{
// TELLS MONGODB THAT THERE NEEDS TO BE AN IMPLEMENTATION FOR THIS
    UserModel findByUsername(String username);
}
