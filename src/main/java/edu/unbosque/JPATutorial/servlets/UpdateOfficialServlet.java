package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.OfficialService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateOfficialServlet", value = "/update-official")
public class UpdateOfficialServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String name = request.getParameter("name");

        OfficialService officialService = new OfficialService();
        officialService.updateOfficial(username, name);

        response.sendRedirect("./index.jsp");

    }

}

