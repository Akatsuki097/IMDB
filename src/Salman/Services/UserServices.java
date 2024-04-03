package Salman.Services;

import Salman.Model.User;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.ArrayList;
import java.util.List;

public class UserServices {
    public static volatile UserServices instance;
    private List<User> userList;

    private UserServices(){
        userList = new ArrayList<>();
    }

    public static synchronized UserServices getInstance(){
        if(instance == null){
            instance = new UserServices();
        }
        return instance;
    }

    public void registerUser(String name, int age, String email){
        User user = new User(name,age,email);
        if(userList.contains(user)){
            System.out.println("Already registered!");
        }else{
            userList.add(user);
            System.out.println("Registration Complete!");
        }

    }

}
