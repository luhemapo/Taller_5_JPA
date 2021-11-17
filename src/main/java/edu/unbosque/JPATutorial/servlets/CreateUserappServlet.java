package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.UserappService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateUserappServlet", value = "/create-userapp")
public class CreateUserappServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        UserappService userappService = new UserappService();
        userappService.saveUserapp(username, password, email, role);

        if(role.equalsIgnoreCase("official")){
            response.sendRedirect("./index.jsp");
        }else if (role.equalsIgnoreCase("owner")){
            response.sendRedirect("./index.jsp");
        }else if (role.equalsIgnoreCase("vet")){
            response.sendRedirect("./form-vet.jsp");
        }
    }

}

