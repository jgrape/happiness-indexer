package controllers;

import models.Team;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Objects;


public class Teams extends Controller {
  public static Result show(final Long teamId) {
    final Team team = Team.find.byId(teamId);
    Objects.requireNonNull(team);

    return ok(views.html.teams.show.render(team));
  }

}
