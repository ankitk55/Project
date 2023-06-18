package org.ankit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {
   public static String mess;
@Autowired
    student s;
@Autowired
        @Qualifier("3parameter")
car c;

    @GetMapping("getobjectstudent")
    public student getObject(){
        mess = s.toString();
        EmailSender.sendMail();
        return s;
    }
    @GetMapping("getobjectcar")
    public car getobjectcar(){
        mess =c.toString();
        EmailSender.sendMail();


        return c;

    }
    @PostMapping("setValueofStudent")
    public void setvalue(){
        s.setAge(25);
        s.setName("Amit");
        s.setGender("Male");
    }


}
