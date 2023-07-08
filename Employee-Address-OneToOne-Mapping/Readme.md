
## Employee-Address-OneToOne-Mapping




### Feature
- Add Employees 
- Update Employees  information
- Delete Employee by ID
- Get Employee  Information by ID
- List all Employees
- Add Address
- Update Address Information
- Get Employee  Information by ID
- List All Addressses
- Delete Address by Id

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
         EmployeeController
         AddressController
    2. Service
         EmployeeService 
         AddressService
    3. Repository
         IEmployeeRepo
         IAddressRepo
    4. Model
         Employee
         Address 
      
### Usage
### API Endpoints
The following API endpoints are available for performing CRUD operations on Employee and Address entities:

Employee Endpoints:

- GET /employees: Retrieve all employees.
- GET /employees/{id}: Retrieve an employee by ID.
- POST /employees: Create a new employee.
- PUT /employees/{id}: Update an existing employee.
- DELETE /employees/{id}: Delete an employee.
 Address Endpoints:

- GET /addresses: Retrieve all addresses.
- GET /addresses/{id}: Retrieve an address by ID.
- POST /addresses: Create a new address.
- PUT /addresses/{id}: Update an existing address.
- DELETE /addresses/{id}: Delete an address.
    
###  Conclusion
This project provides a basic structure for handling one-to-one mapping between Employee and Address entities using Spring Boot and a SQL database. You can use this as a starting point and extend it further based on your specific requirements.

### Author
 👨‍💼 **Ankit Kumar**
 + Github : [Ankit kumar](https://github.com/ankitk55?tab=repositories)
 + Linkdin : [Ankit Kumar](https://www.linkedin.com/in/ankit-kumar-7300581b3/)
 
### 🤝 Contributing
Contributions, issues and feature requests are Welcome!\
Feel free to check [issues Page](https://github.com/issues) 

### Show Your Support 
 Give a ⭐ if this project help you!