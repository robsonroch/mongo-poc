package br.com.robson.apipocmongo.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import br.com.robson.apipocmongo.entities.Sistema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "onboarding")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OnboardingProperties {
    private List<Sistema> sistema;

}