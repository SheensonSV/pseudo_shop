package main;

import main.faсade.ProductFacade;
import main.faсade.UserFacade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.Query;

@SpringBootApplication
public class Shop {
    public static void main(String[] args) {
        SpringApplication.run(Shop.class, args);
    }

    @Bean
    CommandLineRunner lineRunner(ProductFacade productFacade, UserFacade userFacade) {
        return args -> {
//            String hql = "update Contact "
//                    + "SET firstName = :name "
//                    +   ", lastName  = :lastName "
//                    +   ", date      = :dateParam "
//                    +  " where id = :idParam";
//            Query query = null ;
//
//            query.setParameter("idParam"  , 48);
//            query.setParameter("name"     , "Киса");
//            query.setParameter("lastName" , "Воробьянинов");
//
//            int result = query.executeUpdate();
        };
    }

}
