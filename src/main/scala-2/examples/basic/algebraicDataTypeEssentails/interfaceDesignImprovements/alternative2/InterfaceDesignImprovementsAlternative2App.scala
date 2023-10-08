package examples.basic.algebraicDataTypeEssentails.interfaceDesignImprovements.alternative2

object InterfaceDesignImprovementsAlternative2App extends App {
  import Expression._
  import GetUsersRequest._
  import Predicate._

  val userService: UserService = LocalUserService()

  /** Again, that one famous user. */
  userService
    .getUsers(GetUsersRequest(
      ByGivenName(Exact("Grace")) &
        ByGivenName(Exact("Hopper")),
    ))

  /** Still ''that'' Grace Hopper in particular! */
  userService
    .getUsers(GetUsersRequest(
      ByEmailAddress(Exact("grace.hopper@navy.mil")),
    ))

  /** She might be here or there! */
  userService
    .getUsers(GetUsersRequest(
      (ByCity(Exact("Arlington")) & ByRegion(Exact("Virginia"))) |
        (ByCity(Exact("New York")) & ByRegion(Exact("New York"))),
    ))

  /** Added bonus, who hasn't set an email address yet? */
  userService
    .getUsers(GetUsersRequest(
      ByEmailAddress(IsNull),
    ))

}
