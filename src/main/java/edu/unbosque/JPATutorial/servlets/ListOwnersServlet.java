package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.OwnerService;
import edu.unbosque.JPATutorial.servlets.pojos.OwnerPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listOwnersServlet", value = "/list-owners")
public class ListOwnersServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        OwnerService ownerService = new OwnerService();
        List<OwnerPOJO> owner =  ownerService.listOwners();

        String ownerJsonString = new Gson().toJson(owner);

        PrintWriter out = response.getWriter();
        out.print(ownerJsonString);
        out.flush();

    }

}

