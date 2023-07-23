# Instagram Design




### Feature
```
- User
    1. User can create new Account.
    2. User can sign In existing Account.
    3. Signed In User can create Post.
    4. Signed In User can delete Posts  .
    5. Signed In User can do like and comment on a Post .
    6. Signed In User can delete like and comment from a Post.
    7. Signed In User can follow another User.
    8. Signed In User can unfollow a User.
    9. Signed In User can get count of total likes on a Post By Id.
    10. Signed In User can logout from Account.
    
```

### Technologies Used
```
- Programming Language: Java
- Web Framework: SpringBoot
- Database : The project utilizes the MySQL database for data storage.
- Hibernate (for ORM)
- Maven (for dependency management)
- To test endPoints used Swagger

```
### Data flow in Project
```
 Controller
    1.UserController
  Service
    1. UserService
    2. CommentService
    3. AuthenticationService
    4. LikeService
    5. FollowService
    6. PostService
  Repository
    1. IUserRepo
    2. ICommentRpo
    3. IAuthenticationTokenRepo
    4. ILikeRepo
    5. IFollowRepo
    6. IPostRepo
  Model
    1. User
    2. Post 
    3. AuthenticationToken
    4. Like
    5. Comment
    6. Follow

```

### Validation Rules
- User Email should be a normal Email like - ("something@something.com")
- Null comments not allowed.


    
###  Conclusion
This is an Instagram Backend project that consists of many entities:  User, Post,Comment,Like,follow .From this project a valid User can do the CRUD operations with the entities.
In this project I used passwordEncryptor which save the password in database in hashCode.
This Project provide a email Authentication when a user sign in his Account , a Token received that user mail.This Token will be valid when till user is sign in his Account after sign out the token will be expired.
With the help of token the valid user can do CRUD operations .
The project utilizes different types of mappings between these entities to establish relationships and functionality within the system.
And unregistered User can't do antthing.

### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!