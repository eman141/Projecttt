/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttt;

/**
 *
 * @author Memo
 */
public class AuthenticationManager implements AuthenticationService{
        
      private static AuthenticationManager instance;
    private String currentUser;

    private AuthenticationManager() {}

    public static AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    public void login(String username) {
        this.currentUser = username;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    @Override
    public boolean authenticate(String username, String password) {
          return true;
          
    }
}
