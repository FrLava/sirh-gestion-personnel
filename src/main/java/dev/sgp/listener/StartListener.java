package dev.sgp.listener;

import java.time.ZonedDateTime;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class StartListener implements ServletContextListener {
    
    @Inject private CollaborateurService collabService;
    @Inject private DepartementService ds;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ZonedDateTime dateHeureCreation = ZonedDateTime.now();
        
        Departement rh = new Departement("RH");
        Departement it = new Departement("IT");
        Departement compta = new Departement("Comptabilite");
 
        Stream.of(
        		rh,
        		it,
        		compta)
        .forEach(departement -> ds.sauvegarderDepartement(departement));
        
        Stream.of(
                new Collaborateur( "ee", "ss","2 hameau de bellefontaine", "121212121212121","1992-10-10",rh),
                new Collaborateur( "est", "rr", "2 hameau de bellefontaine", "121212121212121", "1992-10-10",rh),
                new Collaborateur( "pmp", "cdr", "2 hameau de bellefontaine", "121212121212121", "1992-10-10",it),
                new Collaborateur( "sar", "vif", "2 hameau de bellefontaine", "121212121212121", "1992-10-10",it),
                new Collaborateur( "pop", "youpi", "2 hameau de bellefontaine", "121212121212121", "1992-10-10",compta)
                
        ).forEach(collab -> collabService.sauvegarderCollaborateur(collab));
        
        
         
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }
}
