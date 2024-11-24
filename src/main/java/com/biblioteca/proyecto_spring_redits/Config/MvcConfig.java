package com.biblioteca.proyecto_spring_redits.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //esta anotación indica que la clase es de configuración
public class MvcConfig implements WebMvcConfigurer {
    //WebMvcConfigurer:interfaz de Spring que permite personalizar el patrón MVC,
    //creando métodos específicos.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    //addViewController(ViewControllerRegistry registry): permite mapear URLS a vistas directamente
    //registry.addViewController("/login"): Agrega un controlador de vista para la URL /login.
    // es decir, que cuando un usuario navega a /login, se mostrará la vista
    // correspondiente (que deberías tener definida en tu aplicación, como un archivo HTML o JSP).

//por tanto, la funcionalidad es que cuando se acceda a /Login nos vamos a la vista especificada.

}
