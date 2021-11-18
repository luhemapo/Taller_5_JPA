package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.PetService;
import edu.unbosque.JPATutorial.servlets.pojos.PetPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listPetsServlet", value = "/list-pets")
public class ListPetsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PetService petService = new PetService();
        List<PetPOJO> pet =  petService.listPets();

        String petJsonString = new Gson().toJson(pet);

        PrintWriter out = response.getWriter();
        out.print(petJsonString);
        out.flush();

    }

}

