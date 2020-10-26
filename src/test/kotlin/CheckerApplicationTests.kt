import com.webpage.checker.CheckerService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CheckerApplicationTests {
    private val url = "https://www.amazon.com/gp/registry/wishlist/153OV2P85MJD6/ref=cm_wl_list_o_0?sort=universal-price&view=null&filter=price-drop"
    private val priceDropPercent = 60
    private val maxPrice = 5

    @Test
    fun `Test New Items By Price Drop Percentage`() {
        val priceDrops = CheckerService.retrieveByPriceDrop(url, true, priceDropPercent)
        println(priceDrops.toString())
        assertEquals(0, priceDrops.size)
    }

    @Test
    fun `Test New Items By Price`() {
        val priceDrops = CheckerService.retrieveByPriceDrop(url, false, maxPrice)
        println(priceDrops.toString())
        assertEquals(0, priceDrops.size)
    }
}
