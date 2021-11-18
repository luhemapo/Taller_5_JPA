package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.PetcaseService;
import edu.unbosque.JPATutorial.servlets.pojos.PetcasePOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listPetcasesServlet", value = "/list-petcases")
public class ListPetcasesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PetcaseService petcaseService = new PetcaseService();
        List<PetcasePOJO> petcase =  petcaseService.listPetcases();

        String petcaseJsonString = new Gson().toJson(petcase);

        PrintWriter out = response.getWriter();
        out.print(petcaseJsonString);
        out.flush();

    }

}

