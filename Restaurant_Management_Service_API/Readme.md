# Restraurant Management API




### Feature
```
- User
    1. User can create new Account.
    2. User can sign In existing Account.
    3. Signed In User can create Order. 
    4. Signed In User can track Order status.
    5. Signed In User can delete own Order.
    6. Signed In User can get All Orders which is created by Own.
    7. User can get the Food List.
    8. Signed In User can logout from Account.
    9. Signed In User can delete own Account.

- Admin
    1. Admin can create new Account.
    2. Admin can sign In existing Account.
    3. Signed In Admin can add List of food. 
    4. Signed In Admin can update the User Order status.
    5. Signed In Admin can delete a particular User Order by Id.
    6. Signed In Admin can add List of food. 
    7. Admin can get the Food List.
    8. Signed In Admin can List of All Users.
    9. Signed In Admin can List of All Visitors.
    10.Signed In Admin can delete a User by userId. 
    11.Signed In Admin can logout from your own Account.

- Visitor
    1. Visitors can get the List of food.

```

### Technologies Used
```
- Programming Language: Java
- Web Framework: SpringBoot
- Database : The project utilizes the MySQL database for data storage.
- Hibernate (for ORM)
- Maven (for dependency management)
```
###  Data Flow in Project
    1. Controller
         UserController
         AdminController
         VisitorController
    2. Service
         UserService 
         AdminService
         AuthenticationService
         FoodService
         OrderService
         VisitorService
    3. Repository
         IAdminRepo
         IUsereRepo
         IFoodRepo
         IOrderRepo
         IVisitorsRepo
         IAuthenticationTokenRepo

    4. Model
         Admin 
         User
         Order 
         Visitor
         Food
         AuthenticationToken
      
### Validation Rules
- Admin Email should be end with "@admin.com" and should have only alphanumeric and digits. ("example12@admin.com")
- User Email should be a normal Email like - ("example12@gmail.com")

    
###  Conclusion
This is an Restaurant management project that consists of many entities: Admin, User, Visitor, Order, Food .This Project doing some CRUD operations on those entities.
In this project I used passwordEncryptor which save the password in database in hashCode.
This Project provide a email Authentication when a user sign in a Token received that user mail.This Token will be valid when till user is sign in after sign out the token will be expired.
With the help of token the user can do different operations .
And token process is same in the case of Admin.

The project utilizes different types of mappings between these entities to establish relationships and functionality within the system.

### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!