package controllers

import buffer.{Buf, Dummy}
import javax.inject._
import org.slf4j.LoggerFactory
import play.api.mvc._



/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  private val log = LoggerFactory.getLogger(getClass)



  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { _ =>

    log.debug("Increment memory")

    for (i <- 1 to 2000000) {
       Buf.col.append(Dummy(1, "dad"))
    }
    Ok("Added;")
  }

  def clean() = Action { _ =>
    Buf.col.clear()

    Ok("Cleaned")
  }
}
