package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.PetcaseService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "cretatePetcaseServlet", value = "/create-petcase")
public class CreatePetcaseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String created_at = dtf4.format(LocalDateTime.now());
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String pet_id = request.getParameter("pet_id");

        PetcaseService petcaseService = new PetcaseService();
        petcaseService.savePetcase(created_at, type, description, pet_id);

        response.sendRedirect("./list-owner.jsp");
    }

}
