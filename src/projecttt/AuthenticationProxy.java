package projecttt;

public class AuthenticationProxy {

    public boolean authenticate(String username, String password) {
        // الطباعة على الكونسول لمتابعة العملية
        System.out.println("Authenticating user: " + username);  // طباعة اسم المستخدم
        
        // افترض أن هناك قاعدة بيانات أو خدمة تتحقق من البيانات المدخلة
        // في هذه الحالة سنضع تحقق وهمي كما يلي:
        if (username.equals("admin") && password.equals("password123")) {
            System.out.println("Authentication successful!");  // تم التحقق بنجاح
            return true;
        } else {
            System.out.println("Authentication failed for user: " + username);  // فشل التحقق
            return false;
        }
    }
}

