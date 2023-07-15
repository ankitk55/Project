# Student Model with Mappings




### Feature
```
1. Student
2. Address
3. Course
4. Book
5. Laptop
We can do CRUD operations on All Entities.

```

### Technologies Used
```
- Programming Language: Java
- Web Framework: SpringBoot
- Database : The project utilizes the MySQL database for data storage.
- Hibernate (for ORM)
- Maven (for dependency management)
```
### Data flow in Project
```
    1.Controller
    2. Service
    3. Repository
    4. Model
```

## Entity Relationships
- **Address** and **Student** have a **One-to-One mapping**. Each Address can have  associated with one student, and each student can be linked to only one address.

- **Book** and **Student** have a **Many-to-One mapping**. Many books can be take by a single student, but each book belongs to only one student.

- **Course** and **Student** have a **Many-to-Many** mapping. Each course can contain multiple students, and each students can be associated with all courses.

- **Laptop** and **Student** have a **One-to-One** mapping. Each Laptop can have  associated with one student, and each student can be linked to only one Laptop.
###  Conclusion
This Student Model can manage Student data a particular college/school that consists of many entities: Student, Book, Course, Address, Laptop .This Project doing some CRUD operations on those entities.
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