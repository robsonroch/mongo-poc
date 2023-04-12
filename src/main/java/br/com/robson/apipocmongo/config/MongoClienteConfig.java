package br.com.robson.apipocmongo.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Arrays;

@Configuration
public class MongoClienteConfig {

public static MongoClient create(String host, int port, String username, String password, String truststorePath, String truststorePassword) throws Exception {
        
        // Configura o SSLContext com o truststore
        KeyStore truststore = KeyStore.getInstance("JKS");
        truststore.load(new FileInputStream(truststorePath), truststorePassword.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(truststore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
        
        // Cria as credenciais para autenticação
        MongoCredential credential = MongoCredential.createCredential(username, "admin", password.toCharArray());

        // Configura as opções do cliente
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToSslSettings(builder -> builder.enabled(true).context(sslContext))
                .credential(credential)
                .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(host, port))))
                .build();
        
        // Retorna uma instância do MongoClient
        return MongoClients.create(settings);
    }
}
