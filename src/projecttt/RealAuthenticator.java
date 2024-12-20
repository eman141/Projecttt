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
public class RealAuthenticator {
     public boolean authenticate(String username, String password) {
        // منطق التحقق الفعلي: هنا نتأكد فقط من أن البيانات هي "admin" و "password"
        return "admin".equals(username) && "password".equals(password);
    }
}
