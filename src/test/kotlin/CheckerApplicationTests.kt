import com.webpage.checker.CheckerService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CheckerApplicationTests {
    // variables for testing by maximum price
    private val priceDropUrl = "https://www.amazon.com/gp/registry/wishlist/153OV2P85MJD6?sort=universal-price"
    private val maxPrice = 5
    
    // variables for testing by price drop percentage
    private val percentDropUrl = "https://www.amazon.com/gp/registry/wishlist/2YYV6XNS7GF9U?sort=universal-price"
    private val priceDropPercent = 60

    @Test
    fun `Test find items by Maximum Price`() {
        val priceDrops = CheckerService.retrieveByPriceDrop(priceDropUrl, false, maxPrice)
        priceDrops.forEach { println(it) }
        assertEquals(0, priceDrops.size)
    }

    @Test
    fun `Test find items by Price Drop Percentage`() {
        val priceDrops = CheckerService.retrieveByPriceDrop(percentDropUrl, true, priceDropPercent)
        priceDrops.forEach { println(it) }
        assertEquals(0, priceDrops.size)
    }
}
