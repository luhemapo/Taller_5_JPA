package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.OfficialService;
import edu.unbosque.JPATutorial.services.UserappService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateOfficialServlet", value = "/create-official")
public class CreateOfficialServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "official";
        String username = request.getParameter("username");
        String name = request.getParameter("name");


        UserappService userappService = new UserappService();
        userappService.saveUserapp(username, password, email, role);

        OfficialService officialService = new OfficialService();
        officialService.saveOfficial(username, name);



        response.sendRedirect("./index.jsp");

    }

}

