package com.furkanturk.security.basic_auth;

import com.furkanturk.security.basic_auth.dto.CreateUserRequest;
import com.furkanturk.security.basic_auth.model.Role;
import com.furkanturk.security.basic_auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData(){
		CreateUserRequest request=new CreateUserRequest(
				"furkan",
				"furkan",
				"123321",
				Set.of(Role.ROLE_USER)
		);
		userService.createUser(request);

		CreateUserRequest request2=new CreateUserRequest(
				"fatih",
				"fatih",
				"123321",
				Set.of(Role.ROLE_ADMIN)
		);
		userService.createUser(request2);
	}
}
