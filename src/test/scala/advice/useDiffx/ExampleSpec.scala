package advice.useDiffx

import advice.useDiffx.diffx.instances._
import com.softwaremill.diffx.scalatest.DiffShouldMatcher._
import org.scalatest.flatspec.FixtureAnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class ExampleSpec extends FixtureAnyFlatSpec {
  import ExampleSpec.Fixtures
  import ExampleSpec.samples

  "assertion failures".can("hard to understand") in { fixtures =>
    import fixtures.getFulfillment

    getFulfillment.byId(samples.fulfillment.id)
      .shouldEqual(Some(samples.fulfillment))
  }

  it should "be easy to see the cause" in { fixtures =>
    import fixtures.getFulfillment

    getFulfillment.byId(samples.fulfillment.id)
      .shouldMatchTo(Some(samples.fulfillment))
  }

  override protected type FixtureParam = Fixtures
  override protected def withFixture(test: OneArgTest) = {
    val getFulfillment = new GetFulfillment(
      fulfillments = Seq(samples.fulfillment),
    )

    test(Fixtures(
      getFulfillment = getFulfillment,
    ))
  }

}

object ExampleSpec {

  case class Fixtures(
    getFulfillment: GetFulfillment,
  )

  object samples {
    import Payment.Cash
    import Payment.CreditCard
    import Payment.CreditCard.Expiration
    import Payment.CreditCard.Number
    import Payment.CreditCard.Security
    import Product.Kind
    import Product.Make
    import Product.Model
    import Product.Year

    val fulfillment: Fulfillment = Fulfillment(
      id = Fulfillment.Id(123),
      cart = Cart(
        products = Seq(
          Product(
            kind = Kind("kind"),
            make = Make("make"),
            model = Model("model"),
            year = Year("year"),
          ),
          Product(
            kind = Kind("kind"),
            make = Make("make"),
            model = Model("model"),
            year = Year("year"),
          ),
        ),
      ),
      payments = Seq(
        Cash,
        CreditCard(
          number = Number(
            issuerCode = 1234,
            accountNumber = 456789,
            checkDigit = 1,
          ),
          expiration = Expiration(
            month = 2,
            year = 2023,
          ),
          security = Security(
            code = 123,
          ),
        ),
      ),
    )
  }

}
