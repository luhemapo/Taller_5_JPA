package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.UserappService;
import edu.unbosque.JPATutorial.services.VetService;
import edu.unbosque.JPATutorial.servlets.pojos.UserappPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.VetPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listVetsServlet", value = "/list-vets")
public class ListVetsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        VetService vetService = new VetService();
        List<VetPOJO> vet =  vetService.listVets();

        String vetJsonString = new Gson().toJson(vet);

        PrintWriter out = response.getWriter();
        out.print(vetJsonString);
        out.flush();

    }

}

