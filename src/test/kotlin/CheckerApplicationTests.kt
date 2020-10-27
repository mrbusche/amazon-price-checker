import com.webpage.checker.CheckerService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CheckerApplicationTests {
    private val priceDropUrl = "https://www.amazon.com/gp/registry/wishlist/153OV2P85MJD6?sort=universal-price"
    private val percentDropUrl = "https://www.amazon.com/gp/registry/wishlist/2YYV6XNS7GF9U?sort=universal-price"
    private val priceDropPercent = 50
    private val maxPrice = 5

    @Test
    fun `Test New Items By Price`() {
        val priceDrops = CheckerService.retrieveByPriceDrop(priceDropUrl, false, maxPrice)
        println(priceDrops.toString())
        assertEquals(0, priceDrops.size)
    }

    @Test
    fun `Test New Items By Price Drop Percentage`() {
        val priceDrops = CheckerService.retrieveByPriceDrop(percentDropUrl, true, priceDropPercent)
        println(priceDrops.toString())
        assertEquals(0, priceDrops.size)
    }
}
