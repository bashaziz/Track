/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bash;

import java.io.IOException;
import java.util.Date;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 *
 * @author bash_aziz
 */
public class GpsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
		
    String location = req.getParameter("location");
    String GpsName = "GP-735";
    Date date = new Date();
        
    System.out.println("Gps = "+GpsName+" Location: "+" Date:"+date);
        
    Key gpsDataKey = KeyFactory.createKey("gpsData", GpsName);
    Entity gpsData = new Entity("Gps", gpsDataKey);
    gpsData.setProperty("date", date);
    gpsData.setProperty("location", location);
    
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(gpsData);
    resp.setContentType("text/plain");
    resp.getWriter().println("Bash's FYP\n" + GpsName + " was found at Lat Long: " + location);
    //resp.sendRedirect("/index.jsp?sensor="+ GpsName);

	
    }
}
