package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.VisitService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "cretateVisitServlet", value = "/create-visit")
public class CreateVisitServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String created_at = dtf4.format(LocalDateTime.now());
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String pet_id = request.getParameter("pet_id");
        String vet_id = request.getParameter("vet_id");


        VisitService visitService = new VisitService();
        visitService.saveVisit(created_at, type, description, pet_id, vet_id);

        response.sendRedirect("./list-owner.jsp");
    }

}
