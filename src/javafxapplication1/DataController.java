/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;

/**
 *
 * @author wolf
 */
public class DataController {

    static ArrayList users = new ArrayList<UserClass>();
    static String login;
    public static void setLogin(String loginName){
        login = loginName;
    }
    public static String getLogin(){
        return login;
    }
    public static UserClass getUser(String name) {
        System.out.println("Current passed login name is" + login);
        boolean userFound = false;
        if (users.size() > 0) {
            for (int i = 0; i <= users.size(); i++) {
                UserClass user = (UserClass) users.get(i);
                if (user.getName().matches(name)) {
                    userFound = true;
                    return user;

                }

            }
        }
        else{
            users.add(new UserClass(name));
            return getUser(name);
        }
        if(userFound == false){
            users.add(new UserClass(name));
            return getUser(name);
        }
        return null;
        
    }

    public static void addUser(String name) {
        users.add(new UserClass(name));
    }
}
