package com.geekster.springbootannotation.Controllers;

import com.geekster.springbootannotation.MailHandler;
import com.geekster.springbootannotation.MyObjects.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    @Qualifier("blue")
    Car c;


    @GetMapping("tree")
    public String getSomething()
    {

        MailHandler mailHandler =new MailHandler();
        mailHandler.sendMail();
        return c.getColor()+" was called just by local server";
    }







}