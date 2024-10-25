package com.example.adminclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class JNDIUtils {

    public static Context getInitialContext() throws NamingException {
        Properties env = new Properties();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        // Si vous avez configuré une authentification, ajoutez les propriétés suivantes :
        // env.put(Context.SECURITY_PRINCIPAL, "nom_utilisateur");
        // env.put(Context.SECURITY_CREDENTIALS, "mot_de_passe");

        return new InitialContext(env);
    }
}
