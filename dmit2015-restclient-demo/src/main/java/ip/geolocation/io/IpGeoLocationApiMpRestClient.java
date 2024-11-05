package ip.geolocation.io;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RequestScoped
@RegisterRestClient(baseUri = "https://api.ipgeolocation.io")
public interface IpGeoLocationApiMpRestClient {

    @GET
    @Path("ipgeo")
    GeoLocationApiResponse getIpGeoLocation(
            @QueryParam("ip") String ip,
            @QueryParam("apiKey") String apiKey);

}
