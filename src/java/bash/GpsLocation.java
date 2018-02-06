/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bash;

//import com.google.appengine.api.datastore.Query;
import bash.PMF;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class GpsLocation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PersistenceManager pm = PMF.get().getPersistenceManager();
            try {
                String queryString = "SELECT * FROM Gps ORDER BY date DESC";
                Query query = pm.newQuery(queryString);
                query.setRange(0,0);
                List<String> result = (List<String>)query.execute();
                response.setContentType("text/plain");
                response.getWriter().println("Bash's FYP\nLatest Location Data:\n" + result.get(1)); 
                
            } finally {
                pm.close();
            }

    }

}
