package ch.bfh.bti7081.s2018.yellow.health.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.repo.UserRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.MyUI;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.login.LoginViewImpl;

@Service
public class UserService {
	private static LoginViewImpl view  = new LoginViewImpl();
	
	private static SecureRandom random = new SecureRandom();
    private static Map<String, String> rememberedUsers = new HashMap<>();
    
    private static UserRepository repo;

 
   private UserRepository crepo;
    
   @Autowired   
   public UserService(UserRepository repo) {
    	UserService.repo = repo;
    }

    
    public static boolean isAuthenticUser(String username, String password) {
    	System.out.println(username);    
    	String pw = repo.findPassword(username);
		if(password.equals(pw))
		{
			return true;
		} else {
			return false;                 
		}     
    }



    public static String rememberUser(String username) {
        String randomId = new BigInteger(130, random).toString(32);
        rememberedUsers.put(randomId, username);
        return randomId;
    }

    public static String getRememberedUser(String id) {
        return rememberedUsers.get(id);
    }

    public static void removeRememberedUser(String id) {
        rememberedUsers.remove(id);
    }
}
