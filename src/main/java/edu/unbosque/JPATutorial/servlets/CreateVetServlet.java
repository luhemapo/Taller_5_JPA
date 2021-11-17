package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.UserappService;
import edu.unbosque.JPATutorial.services.VetService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateVetServlet", value = "/create-vet")
public class CreateVetServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = "vet";
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String neighborhood = request.getParameter("neighborhood");
        String vet_id = request.getParameter("vet_id");


        UserappService userappService = new UserappService();
        userappService.saveUserapp(username, password, email, role);

        VetService vetService = new VetService();
        vetService.saveVet(username, name, address,neighborhood,vet_id);



        response.sendRedirect("./index.jsp");

    }

}

