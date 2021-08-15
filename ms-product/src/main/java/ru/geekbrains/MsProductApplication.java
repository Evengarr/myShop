package ru.geekbrains;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.geekbrains.AOP.AppConfig;
import ru.geekbrains.controllers.ProductController;

@SpringBootApplication
public class MsProductApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MsProductApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductController controller = context.getBean("productController", ProductController.class);

        controller.findProductById(5L);
        context.close();
    }

}
