package br.com.soccerbetsurvivor.db.container;

import org.testcontainers.containers.MySQLContainer;

public class MySQLDBContainer extends MySQLContainer<MySQLDBContainer> {

    private static final String IMAGE_VERSION = "mysql:5.7";
    private static MySQLDBContainer container;
    
    private MySQLDBContainer() {
        super(IMAGE_VERSION);
    }
    
    public static MySQLDBContainer getInstance() {
        
        if(container == null) {
            container = new MySQLDBContainer()
                    .withDatabaseName("survivor")
                    .withUrlParam("useSSL", "false")
                    .withUrlParam("verifyServerCertificate", "false");
            
        }
        return container;
    }
    
    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }
 
    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
        
}