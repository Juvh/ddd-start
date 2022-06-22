package juv.study.books.dddstart.chapter04.shop.order.domain

import juv.study.books.dddstart.chapter04.shop.catalog.domain.ProductId
import juv.study.books.dddstart.chapter04.shop.common.Money
import juv.study.books.dddstart.chapter04.shop.common.MoneyConverter
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
data class OrderLine(
    @Embedded
    val productId: ProductId,

    @Column(name = "price")
    @Convert(converter = MoneyConverter::class)
    val price: Money,

    @Column(name = "quantity")
    val quantity: Int,

    @Column(name = "amounts")
    @Convert(converter = MoneyConverter::class)
    val amounts: Money = price * quantity
)