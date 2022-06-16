package juv.study.books.dddstart.chapter01.order

class Money(val value: Int) {

    // add
    operator fun plus(other: Money) = Money(value = this.value + other.value)

    // multiply
    operator fun times(other: Int) = Money(value = this.value * other)
}
