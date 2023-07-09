
# E-Commerce Project




### Feature
- Add User 
- Get User by Id
- Add Product
- Get Product by ID
- List all Product
- Delete Product by Id
- Create Order
- Get Order  Information by Id
- Add Address 

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
         AddressController
         ProductController
         OrderEntityController
    2. Service
         UserService 
         AddressService
         ProductService
         OrderEntityService
    3. Repository
         IUsereRepo
         IAddressRepo
         IProductRepo
         IOrderEntityRepo
    4. Model
         User
         Address 
         Product
         OrderEntity
      
## Entity Relationships
- **Address** and **User** have a **One-to-One mapping**. Each Address can have  associated with one user, and each user can be linked to only one address.

- **Order** and **User** have a **Many-to-One mapping**. Many orders can be placed by a single user, but each order belongs to only one user.

- **Order** and **Product** have a **Many-to-Many** mapping. Each order can contain multiple products, and each product can be associated with all orders.

- **Order** and **Address** have a **Many-to-One** mapping. Many orders can have the same shipping address, but each order can be associated with only one shipping address.
### Usage
### API Endpoints
The following API endpoints are available for performing CRUD operations on Employee and Address entities:

Product Endpoints:

- GET /products: Retrieve all products.
- GET /product/{productCategory}: Retrieve all products based on category.
- POST /product: Add a new product.
- DELETE /product/{id}: Delete  product by Id.

 Address Endpoints:

- POST /addresses: Add a new address.

 Order Endpoints:

-  GET /Order/{id}: Retrieve  Order by Id.
- POST /Order: Create a new Order.
- DELETE /Order/{id}: Delete  Order by Id.

User Endpoints:

-  GET /User/{id}: Retrieve  User  by Id.
- POST /User: Add a new User.

    
###  Conclusion
This is an ECommerce project that consists of four entities: Address, User, Order, and Product.This Project doing some CRUD operations on those entities. The project utilizes different types of mappings between these entities to establish relationships and functionality within the system.

### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!