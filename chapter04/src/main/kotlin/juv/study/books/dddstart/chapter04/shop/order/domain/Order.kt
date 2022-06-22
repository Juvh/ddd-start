package juv.study.books.dddstart.chapter04.shop.order.domain

import juv.study.books.dddstart.chapter04.shop.common.Money
import juv.study.books.dddstart.chapter04.shop.common.MoneyConverter
import javax.persistence.*

@Entity
@Table(name = "purchase_order")
class Order(
    @EmbeddedId
    val number: OrderNo,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "order_line",
        joinColumns = [JoinColumn(name = "order_number")]
    )
    @OrderColumn(name = "line_idx")
    val orderLines: List<OrderLine>,

    @Embedded
    var orderer: Orderer,

    @Embedded
    var shippingInfo: ShippingInfo,

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter::class)
    val money: Money
) {
}