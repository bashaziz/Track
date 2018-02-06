/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bash;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
/**
 *
 * @author USER
 */
public final class PMF {
    private static final PersistenceManagerFactory pmfInstance = 
            JDOHelper.getPersistenceManagerFactory("transactions-optional");
    
    private PMF() {}
    
    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
    
}
