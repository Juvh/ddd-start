package juv.study.books.dddstart.chapter01.order

class Order(
    val orderNumber: String,
    val orderer: Orderer,
    orderLines: List<OrderLine>,
    var shippingInfo: ShippingInfo,
    var state: OrderState
) {

    var orderLines: List<OrderLine> = orderLines
        set(value) {
            check(orderLines.isNotEmpty()) { "no OrderLines" }
            field = value
            this.totalAmounts = calculateTotalAmounts()
        }

    var totalAmounts: Money = calculateTotalAmounts()

    private fun calculateTotalAmounts() =
        orderLines.map(OrderLine::amounts)
            .reduce { acc, money -> acc + money }

    fun changeShippingInfo(newShippingInfo: ShippingInfo) {
        verifyNotYetShipped()
        this.shippingInfo = newShippingInfo
    }

    fun cancel() {
        verifyNotYetShipped()
        this.state = OrderState.CANCELED
    }

    /* Order에서 logic을 구현한 경우
    fun isShippingChangeable() = (state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING)
     */

    private fun verifyNotYetShipped() {
        check(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) { "already shipped" }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (orderNumber != other.orderNumber) return false

        return true
    }

    override fun hashCode(): Int {
        return orderNumber.hashCode()
    }


}

class Orderer {

}
