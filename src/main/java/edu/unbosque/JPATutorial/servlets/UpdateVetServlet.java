package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.UserappService;
import edu.unbosque.JPATutorial.services.VetService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateVetServlet", value = "/update-vet")
public class UpdateVetServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String neighborhood = request.getParameter("neighborhood");

        VetService vetService = new VetService();
        vetService.updateVet(username, name, address,neighborhood);



        response.sendRedirect("./index.jsp");

    }

}

