package com.i.minishopping;

import com.i.minishopping.brand.service.BrandService;
import com.i.minishopping.product.service.detail.DetailService;
import com.i.minishopping.product.service.log.LogService;
import com.i.minishopping.product.service.product.ProductSelectService;
import com.i.minishopping.product.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.i.minishopping.user.service.UserService;

import java.util.Scanner;



@Configuration
@ComponentScan(basePackages = "com.i.minishopping")
public class Main {

    public void menu(ApplicationContext applicationContext){
        Scanner scan = new Scanner(System.in);
        int num;
        BrandService brandService = null;
        UserService userService = null;
        ProductService productService = null;
        DetailService detailService = null;
        LogService logService = null;

        while(true){
            System.out.println();
            System.out.println("1. user");
            System.out.println("2. brand");
            System.out.println("3. product");
            System.out.println("4. detail");
            System.out.println("5. log");
            System.out.println("6. 종료");
            System.out.print("번호 입력 : ");
            num = scan.nextInt();

            if(num == 6) break;

            if(num == 1) {

                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 끝");
                System.out.println("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    userService = (UserService) applicationContext.getBean("userInsertService");
                }else if(num==2) {
                    userService = (UserService) applicationContext.getBean("userSelectService");
                }
                else if(num==3) {
                    userService = (UserService) applicationContext.getBean("userUpdateService");
                }else if(num==4) {
                    userService = (UserService) applicationContext.getBean("userDeleteService");
                } // if-else if

                if(num==5) break;

                userService.execute();

            } else if(num == 2) {
                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 종료");
                System.out.print("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    brandService = applicationContext.getBean("brandInsertService", BrandService.class);
                }else if(num==2) {
                    brandService = applicationContext.getBean("brandSelectService", BrandService.class);
                }
                else if(num==3) {
                    brandService = applicationContext.getBean("brandUpdateService", BrandService.class);
                }else if(num==4) {
                    brandService = applicationContext.getBean("brandDeleteService", BrandService.class);
                } // if-else if

                if(num==5) break;

                brandService.execute();

            } else if(num == 3) {
                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 종료");
                System.out.print("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    productService = applicationContext.getBean("productInsertService", ProductService.class);
                }else if(num==2) {
                    productService = applicationContext.getBean("productSelectService", ProductService.class);
                }
                else if(num==3) {
                    productService = applicationContext.getBean("productUpdateService", ProductService.class);
                }else if(num==4) {
                    productService = applicationContext.getBean("productDeleteService", ProductService.class);
                } // if-else if

                if(num==5) break;

                productService.execute();


            } else if(num == 4) {
                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 종료");
                System.out.print("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    detailService = applicationContext.getBean("detailInsertService", DetailService.class);
                }else if(num==2) {
                    detailService = applicationContext.getBean("detailSelectService", DetailService.class);
                }
                else if(num==3) {
                    detailService = applicationContext.getBean("detailUpdateService", DetailService.class);
                }else if(num==4) {
                    detailService = applicationContext.getBean("detailDeleteService", DetailService.class);
                } // if-else if

                if(num==5) break;

                detailService.execute();

            } else if(num == 5) {
                System.out.println();
                System.out.println("1. 입력");
                System.out.println("2. 출력");
                System.out.println("3. 수정");
                System.out.println("4. 삭제");
                System.out.println("5. 종료");
                System.out.print("번호 입력 : ");
                num = scan.nextInt();

                if(num==1) {
                    logService = applicationContext.getBean("logInertService", LogService.class);
                }else if(num==2) {
                    logService = applicationContext.getBean("logSelectService", LogService.class);
                }
                else if(num==3) {
                    logService = applicationContext.getBean("logUpdateService", LogService.class);
                }else if(num==4) {
                    logService = applicationContext.getBean("logDeleteService", LogService.class);
                } // if-else if

                if(num==5) break;

                logService.execute();

            } else {
                System.out.println("1~6번 선택");
                continue;
            }

        } // while

    } // menu

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("root-context.xml");
        Main main = (Main)applicationContext.getBean("main");
        main.menu(applicationContext);

        System.out.println("\n프로그램 종료합니다");
    } // main

}
