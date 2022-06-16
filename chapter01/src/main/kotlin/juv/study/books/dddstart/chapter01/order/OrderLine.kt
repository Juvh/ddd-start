package juv.study.books.dddstart.chapter01.order

class OrderLine(
    val product: Product,
    val price: Money,
    quantity: Int
) {
    var quantity: Int = quantity
        set(value) {
            field = value
            this.amounts = calculateAmounts()
        }

    var amounts: Money = calculateAmounts()

    private fun calculateAmounts() = this.price * this.quantity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OrderLine

        if (product != other.product) return false
        if (price != other.price) return false
        if (quantity != other.quantity) return false
        if (amounts != other.amounts) return false

        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = product.hashCode()
        result = prime * result + price.hashCode()
        result = prime * result + quantity
        result = prime * result + amounts.hashCode()
        return result
    }

}