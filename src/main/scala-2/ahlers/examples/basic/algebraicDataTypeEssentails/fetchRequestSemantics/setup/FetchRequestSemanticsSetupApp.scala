package ahlers.examples.basic.algebraicDataTypeEssentails.fetchRequestSemantics.setup

object FetchRequestSemanticsSetupApp extends App {

  val userService: UserService = LocalUserService()

  /** It's reasonable to expect this returns, perhaps, one famous user. */
  userService
    .getUsers(GetUsersRequest(
      givenName = Some("Grace"),
      familyName = Some("Hopper"),
    ))

  /** Also reasonable to expect all users named "Grace" are returned. */
  userService
    .getUsers(GetUsersRequest(
      givenName = Some("Grace"),
      familyName = None,
    ))

  /** Are all returned? None? */
  userService
    .getUsers(GetUsersRequest(
      givenName = None,
      familyName = None,
    ))

}
