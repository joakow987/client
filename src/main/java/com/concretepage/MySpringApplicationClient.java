package com.concretepage;
import com.concretepage.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MySpringApplicationClient {


	public static void main(String[] args) {
		SpringApplication.run(MySpringApplicationClient.class, args);
    }       
	@Bean
	CommandLineRunner lookup(ArticleClient articleClient) {
		return args -> {

			
			System.out.println("--- Get ProductList ---");
			GetProductListResponse getProductListResponse = articleClient.getProductList();
			getProductListResponse.getProduct().stream()
			   .forEach(e -> System.out.println(e.getProductId() + ", "+ e.getName()));
			
			System.out.println("--- Add Products To Basket ---");

			List<Product> list = new ArrayList<>();
			list = articleClient.getProductList().getProduct();
			AddToBasketResponse addToBasketResponse = articleClient.addProduct(list.get(0));
			AddToBasketResponse addToBasketResponse1 = articleClient.addProduct(list.get(1));
			AddToBasketResponse addToBasketResponse2 = articleClient.addProduct(list.get(2));
			AddToBasketResponse addToBasketResponse3 = articleClient.addProduct(list.get(3));

			System.out.println("--- Delete Products From Basket ---");
			DeleteFromBasketResponse deleteArticle = articleClient.deleteFromBasket(list.get(0));

			System.out.println("--- Get Basket ---");
			GetBasketResponse getBasketResponse = articleClient.getBasket();
			getBasketResponse.getProduct().stream().forEach( b -> System.out.println(b.getProductId() + ", "+ b.getName()));

		};
	}	
}            