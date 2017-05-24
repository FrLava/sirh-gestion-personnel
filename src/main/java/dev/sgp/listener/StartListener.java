package dev.sgp.listener;

import java.time.ZonedDateTime;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;

@WebListener
public class StartListener implements ServletContextListener {
    
    @Inject private CollaborateurService collabService;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ZonedDateTime dateHeureCreation = ZonedDateTime.now();
 
        Stream.of(
                new Collaborateur( "ee", "ss","2 hameau de bellefontaine", "121212121212121","1992-10-10"),
                new Collaborateur( "est", "rr", "2 hameau de bellefontaine", "121212121212121", "1992-10-10"),
                new Collaborateur( "pmp", "cdr", "2 hameau de bellefontaine", "121212121212121", "1992-10-10"),
                new Collaborateur( "sar", "vif", "2 hameau de bellefontaine", "121212121212121", "1992-10-10"),
                new Collaborateur( "pop", "youpi", "2 hameau de bellefontaine", "121212121212121", "1992-10-10")
                
        ).forEach(collab -> collabService.sauvegarderCollaborateur(collab));
        
        //Stream.of(new Departement());
         
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }
}
