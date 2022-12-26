import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
class TestClass {
    @Test//(1)
    fun `my first test`() {//(2)
        assertEquals(3,1+2)//(3)
    }
}