package co.configuration.game;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/v1/games")
public class GameResource {

  @Inject
  GameRepository gameRepository;

  @GET
  public Response getAllGames() {
    return Response.ok(gameRepository.listAll()).build();
  }
}
