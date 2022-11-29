package adapter.http;

import adapter.http.response.MessageContentResponse;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/emails")
public class EmailController {

    @Inject
    JsonWebToken principal;

    @GET
    @RolesAllowed("AUTHENTICATED_USER")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmails(@QueryParam("limit") long limit, @QueryParam("offset") long offset, @QueryParam("order") String order, @QueryParam("searchTerm") String searchTerm) {
        String username = principal.getSubject();

        String queryParamsCheck = "Limit: " + limit + ", Offset: " + offset + ", Order: " + order + ", Search term: " + searchTerm;

        String tempResponseMessage = "Emails endpoint for authenticated user '" + username + "' with query params - " + queryParamsCheck;
        return Response.ok(new MessageContentResponse(tempResponseMessage)).build();
    }
}
