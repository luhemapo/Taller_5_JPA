package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.PetService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updatePetServlet", value = "/update-pet")
public class UpdatePetServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String pet_id = request.getParameter("pet_id");
        String name = request.getParameter("name");
        String species = request.getParameter("species");
        String race = request.getParameter("race");
        String size = request.getParameter("size");
        String sex = request.getParameter("sex");
        String picture= request.getParameter("picture");

        PetService petService = new PetService();
        petService.updatePet(pet_id, name, species, race, size, sex, picture);



        response.sendRedirect("./list-owner.jsp");

    }

}

