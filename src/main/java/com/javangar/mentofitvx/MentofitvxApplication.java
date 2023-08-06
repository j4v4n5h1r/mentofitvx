package com.javangar.mentofitvx;

import java.io.FileInputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class MentofitvxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentofitvxApplication.class, args);
	}
	
//	@PostConstruct
//    public void initialize() {
//        try {
//            FileInputStream serviceAccount = new FileInputStream("mentofit-firebase-adminsdk-hwyxj-e748c05301.json");
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://mentofit-default-rtdb.europe-west1.firebasedatabase.app")
//                    .build();
//
//            FirebaseApp.initializeApp(options);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}






//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
// 
//@SpringBootApplication(scanBasePackages = "com.javangar.mentofitvx")
//@EnableJpaRepositories
//@EnableTransactionManagement
//public class MentofitvxApplication extends SpringBootServletInitializer {
// 
//    public static void main(String[] args) {
//        SpringApplicationBuilder app = new SpringApplicationBuilder(MentofitvxApplication.class);
//        app.run();
//    }
// 
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(MentofitvxApplication.class);
//    }
//}