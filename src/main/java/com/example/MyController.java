/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author marcos
 */
@Controller
@RequestMapping("/")
public class MyController {

    Logger logger = LoggerFactory.getLogger(MyController.class);

    @PostConstruct
    public void init() {
        FixtureFactoryLoader.loadTemplates("com.example");
    }

    @GetMapping
    public String welcome() {
        logger.info("class: {}", MyClass.class.getName());
        logger.info("class.hashCode: {}", MyClass.class.hashCode());
        logger.info("classLoader: {}", MyClass.class.getClassLoader().getClass().getName());
        MyClass myObject = Fixture.from(MyClass.class).gimme("valid");
        return myObject.getMyField();
    }
}
