/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author marcos
 */
public class MyClassFixture implements TemplateLoader {

    private final Logger logger = LoggerFactory.getLogger(MyClassFixture.class);

    @Override
    public void load() {
        logger.info("class: {}", MyClass.class.getName());
        logger.info("class.hashCode: {}", MyClass.class.hashCode());
        logger.info("classLoader: {}", MyClass.class.getClassLoader().getClass().getName());
        Fixture.of(MyClass.class).addTemplate("valid", new Rule() {
            {
                add("myField", "text");
            }
        });
    }
}
