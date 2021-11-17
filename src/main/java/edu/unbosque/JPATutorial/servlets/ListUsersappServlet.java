package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.UserappService;
import edu.unbosque.JPATutorial.servlets.pojos.UserappPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listUsersappServlet", value = "/list-usersapp")
public class ListUsersappServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        UserappService userappService = new UserappService();
        List<UserappPOJO> usersapp =  userappService.listUsersapp();

        String usersappJsonString = new Gson().toJson(usersapp);

        PrintWriter out = response.getWriter();
        out.print(usersappJsonString);
        out.flush();

    }

}

