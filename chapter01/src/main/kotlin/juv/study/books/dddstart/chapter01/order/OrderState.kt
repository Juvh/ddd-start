package juv.study.books.dddstart.chapter01.order

enum class OrderState {
    PAYMENT_WAITING {
        override fun isShippingChangeable() = true
    },
    PREPARING {
        override fun isShippingChangeable() = true
    },
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED
    ;

    open fun isShippingChangeable() = false
}