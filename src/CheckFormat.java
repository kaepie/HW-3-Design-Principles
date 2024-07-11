import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
//6510450291 Chutipong Triyasith
public class CheckFormat {
    private String namePattern = "[a-zA-Z]+";
    private String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private List<String> notAllowDomains = Arrays.asList("dom1.cc","dom2.cc", "dom3.cc");
    private int minimumAge = 20;
    public void validateName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        }

        if(!name.matches(namePattern)){
            throw new IllegalArgumentException("Name is wrong format");
        }
    }

    public void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email should not be empty");
        }
        Pattern validEmailPattern = Pattern.compile(emailPattern);
        if (!validEmailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is in wrong format");
        }
        String domain = email.split("@")[1];
        if (notAllowDomains.contains(domain)) {
            throw new IllegalArgumentException("Email domain is not allowed");
        }
    }

    public void validateAge(int age) {
        if (age < minimumAge) {
            throw new IllegalArgumentException("Age should be more than " + minimumAge + " years");
        }
    }
}
