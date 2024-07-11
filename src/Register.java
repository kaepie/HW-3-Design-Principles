//6510450291 Chutipong Triyasith
public class Register {
    CheckFormat checkFormat;
    Register(){
        checkFormat = new CheckFormat();
    }
    public boolean register(User user){
        checkFormat.validateName(user.getName());
        checkFormat.validateEmail(user.getEmail());
        checkFormat.validateAge(user.getAge());
        return true;
    }

}
