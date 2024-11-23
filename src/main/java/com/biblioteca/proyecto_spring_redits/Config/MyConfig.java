package com.biblioteca.proyecto_spring_redits.Config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableConfigurationProperties() //permite que Spring cargue propiedades de configuración desde un app.properties en una clase específica (StorageProperties).
//valida los datos para el inicio de sesión.

public class MyConfig {

    @Bean //indica que el método devuelve un bean que deber ser gestionado por
    //el contenedor gestionado por Spring
    public MessageSource messageSource() { // MessaggeSource es un componente que se usa
        //para cargar mensajes de error
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource(); //permite regargar mensajes desde un archivo

        messageSource.setBasename("classpath:errors");
        messageSource.setDefaultEncoding("UTF-8"); //define la codificación que se usará para leer el archivo
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() { //sirve para validar objetos en Spring
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource()); //configura el validador para usar el MEssageSource, nos permite devolver mensajes internacionalizados.
        return bean;
    }

}
