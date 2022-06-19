package juv.study.books.ddstart.chapter02.common.money

class MutableMoney(override var amounts: Int) : Money(amounts) {
    fun toImmutableMoney() = ImmutableMoney(amounts)
}
