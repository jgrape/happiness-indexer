import play.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.libs.F.*;
import static play.mvc.Results.*;


public class Global extends GlobalSettings {

  public void onStart(Application app) {
    Logger.info("Application has started");
  }

  public void onStop(Application app) {
    Logger.info("Application shutdown...");
  }

  public Promise<Result> onError(RequestHeader request, Throwable t) {
    return Promise.<Result>pure(internalServerError(
        views.html.error.render("Internt fel", new scala.Some(t))
    ));
  }


}