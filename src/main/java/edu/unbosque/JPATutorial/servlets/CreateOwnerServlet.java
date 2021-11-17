package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.UserappService;
import edu.unbosque.JPATutorial.services.OwnerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateOwnerServlet", value = "/create-owner")
public class CreateOwnerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "owner";
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String neighborhood = request.getParameter("neighborhood");
        String person_id = request.getParameter("person_id");


        UserappService userappService = new UserappService();
        userappService.saveUserapp(username, password, email, role);

        OwnerService ownerService = new OwnerService();
        ownerService.saveOwner(username, name, address,neighborhood,person_id);



        response.sendRedirect("./index.jsp");

    }

}

