package juv.study.books.dddstart.chapter04.shop.order.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class OrderNo(
    @Column(name = "order_number")
    val number: String
) : Serializable {
    companion object {
        private const val serialVersionUID = -2524620013946740633L
    }
}
