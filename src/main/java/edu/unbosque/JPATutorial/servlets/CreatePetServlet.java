package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.PetService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretatePetServlet", value = "/create-pet")
public class CreatePetServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

         String pet_id = request.getParameter("pet_id");
         String microchip = request.getParameter("microchip");
         String name = request.getParameter("name");
         String species = request.getParameter("species");
         String race = request.getParameter("race");
         String size = request.getParameter("size");
         String sex = request.getParameter("sex");
         String picture= request.getParameter("picture");
         String person_id = request.getParameter("person_id");

        PetService petService = new PetService();
        petService.savePet(pet_id, microchip, name, species, race, size, sex, picture, person_id);


        try {
            response.sendRedirect("./index.jsp");
        } catch (IOException e) {
            response.sendRedirect("./error.jsp");
        }

    }

}

