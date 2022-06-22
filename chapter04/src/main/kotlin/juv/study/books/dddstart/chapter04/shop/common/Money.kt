package juv.study.books.dddstart.chapter04.shop.common

data class Money(
    val amounts: Int
) {
    operator fun plus(other: Money) = Money(amounts = this.amounts + other.amounts)

    operator fun times(times: Int) = Money(amounts = this.amounts * times)
}
