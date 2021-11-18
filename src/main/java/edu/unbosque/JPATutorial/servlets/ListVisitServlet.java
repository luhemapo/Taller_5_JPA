package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.VisitService;
import edu.unbosque.JPATutorial.servlets.pojos.VisitPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listVisitServlet", value = "/list-visit")
public class ListVisitServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        VisitService visitService = new VisitService();
        List<VisitPOJO> visit =  visitService.listVisits();

        String petcaseJsonString = new Gson().toJson(visit);

        PrintWriter out = response.getWriter();
        out.print(petcaseJsonString);
        out.flush();

    }

}

