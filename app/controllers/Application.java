package controllers;

import models.Team;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class Application extends Controller {

  public static Result index() {
    List<Team> teams = Team.find.query().orderBy("name").findList();
    return ok(views.html.index.render(teams));
  }

}
