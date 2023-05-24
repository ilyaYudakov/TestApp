import kotlinx.coroutines.*
import java.math.BigInteger

fun main() = runBlocking{
    
}

object Fibonacci {
    suspend fun take(index: Int): BigInteger {
        return withContext(Dispatchers.Default) {
            if (index == 1) return@withContext BigInteger.ZERO
            var i = 3
            var f1 = 0
            var f2 = 1

            while (i <= index) {
                yield()
                val sum = f1 + f2
                f1 = f2
                f2 = sum
                i++
            }
            return@withContext f2.toBigInteger()
        }
    }
}

