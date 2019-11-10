import classes.Email;
import classes.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPassword", urlPatterns = {"/ForgotPassword"})
public class ForgotPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String tmppass = generateTempPass();

        try{
            if (Validate.checkEmailExistence(email)){
                Validate.changePassword(tmppass, email);

                Email em = new Email();
                String recipient = email;
                String subject = "Password Reset";
                String content = "Your new password is " + tmppass;

                em.sendEmail(recipient, subject, content);
                request.setAttribute("successMessage", "Password was succesfully reset, please check your mail inbox.");
            }else{
                request.setAttribute("errorMessage", "Password was not reset. Email does not exist.");
            }
            request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateTempPass(){
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sbr = new StringBuilder(8);
        for (int i = 0; i <8; i++) {
            int index = (int) (alphaNumericString.length() * Math.random());
            sbr.append(alphaNumericString.charAt(index));
        }
        return sbr.toString();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
