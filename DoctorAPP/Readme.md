# Doctor App




### Feature
```
- Patient
    1. Patient can create new Account.
    2. Patient can sign In existing Account.
    3. Signed In Patient can book an appointment. 
    4. Signed In Patient can canceled their appointment.
    5. Signed In Patient can logout from Account.
   

- Doctor
    1. Add Doctor.
   
- Admin
    1. Add admin
    2. Get All appointments
    3. Get All Doctors.
    4. Get All Patients

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
         PatientController
         DoctorController
         AdminController
    2. Service
         PatientService 
         AdminService
         AuthenticationService
         AppointmentService
         DoctorService
    3. Repository
         IAdminRepo
         IPatientRepo
         IDoctorRepo
         IAppointmentRepo
         IAuthenticationTokenRepo

    4. Model
         Admin 
         Patient
         Doctor
         AuthenticationToken
         Appointment
      
### Validation Rules
- Admin Email should be end with "@admin.com" and should have only alphanumeric and digits. ("example12@admin.com")
- Patient Email should be a normal Email like - ("example12@gmail.com")

    
###  Conclusion
This is an Doctor App project that consists of many entities: Admin, Patients, Appointments, Doctor .This Project doing some CRUD operations on those entities.
In this project I used passwordEncryptor which save the password in database in hashCode.
This Project provide a email Authentication when a Patient sign in a Token received that user mail.This Token will be valid when till user is sign in after sign out the token will be expired.
With the help of token the user can do different operations .

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