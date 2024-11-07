package org.openweathermap.api;

import ip.geolocation.io.IpGeoLocationApiMpRestClient;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import java.io.Serializable;

@Named("currentOpenWeatherApiClientView")
@SessionScoped
public class OpenWeatherApiClientView implements Serializable {

    @Inject
    @ConfigProperty(name = "io.geolocation.api.apikey") // The name is defined in src/main/resources/META-INF/microprofile-config.properties file or an O/S environment variable
    private String ipGeoLocationApiKey;

    @Inject
    @ConfigProperty(name = "org.openweathermap.api.apikey") // The name is defined in src/main/resources/META-INF/microprofile-config.properties file or an O/S environment variable
    private String openweatherApiKey;

    @Inject
    @ConfigProperty(name = "org.openweathermap.api.DefaultCity") // The name is defined in src/main/resources/META-INF/microprofile-config.properties file or an O/S environment variable
    @Getter @Setter
    private String city;    // The city to get the weather for

    @Inject
    @ConfigProperty(name = "org.openweathermap.api.Units") // The name is defined in src/main/resources/META-INF/microprofile-config.properties file or an O/S environment variable
    private String units;    // // The units of measurement: standard, metric, imperial

    @Inject
    @RestClient // Inject the MP Rest Client
    private CurrentWeatherApiResponseMpRestClient _weatherRestClient;

    @Inject
    @RestClient
    private IpGeoLocationApiMpRestClient _geoLocationRestClient;

    @Getter
    private CurrentWeatherApiResponse currentWeatherApiResponse;

    @PostConstruct
    public void init() {
//        String ip = Faces.getRemoteAddr();
//        if (ip.equals("127.0.0.1")) {
//            ip = "192.197.128.13";
//        }
//        var geoLocationApiResponse = _geoLocationRestClient.getIpGeoLocation(
//                ip,ipGeoLocationApiKey);
////        city = geoLocationApiResponse.getCity();
//        currentWeatherApiResponse = _weatherRestClient.getCurrentWeatherByGeographicalCoordinates(
//                geoLocationApiResponse.getLatitude().toString(),
//                geoLocationApiResponse.getLongitude().toString(),
//                openweatherApiKey,
//                units
//        );
//        String message = String.format("The current weather in %s is %.2f",
//                currentWeatherApiResponse.getName(),
//                currentWeatherApiResponse.getMain().getTemp());
//        Messages.addGlobalInfo(message);
//        doSearchByCity();
    }

    public void doSearchByCity() {
        try {
            currentWeatherApiResponse = _weatherRestClient.getCurrentWeatherByCity(city, openweatherApiKey, units);
            String message = String.format("The current weather in %s is %.2f", currentWeatherApiResponse.getName(), currentWeatherApiResponse.getMain().getTemp());
            Messages.addGlobalInfo(message);
        } catch (Exception ex) {
            Messages.addGlobalWarn("There are no weather data for {0}", city);
        }
    }

    /**
     * This method is used to handle exceptions and display root cause to user.
     * @param ex The Exception to handle.
     */
    protected void handleException (Exception ex){
        StringBuilder details = new StringBuilder();
        Throwable causes = ex;
        while(causes.getCause() != null){
            details.append(ex.getMessage());
            details.append("    Caused by:");
            details.append(causes.getCause().getMessage());
            causes = causes.getCause();
        }
        Messages.create(ex.getMessage()).detail(details.toString()).error().add("errors");
    }
}