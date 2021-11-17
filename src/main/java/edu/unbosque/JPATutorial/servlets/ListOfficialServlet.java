package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.OfficialService;
import edu.unbosque.JPATutorial.servlets.pojos.OfficialPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listOfficialServlet", value = "/list-officials")
public class ListOfficialServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        OfficialService officialService = new OfficialService();
        List<OfficialPOJO> official =  officialService.listOfficials();

        String officialJsonString = new Gson().toJson(official);

        PrintWriter out = response.getWriter();
        out.print(officialJsonString);
        out.flush();

    }

}

