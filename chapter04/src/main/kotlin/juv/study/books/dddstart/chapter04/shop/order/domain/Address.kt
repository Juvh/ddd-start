package juv.study.books.dddstart.chapter04.shop.order.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Address(
    @Column(name = "shipping_zipcode")
    val zipCode: String,
    @Column(name = "shipping_addr1")
    val address1: String,
    @Column(name = "shipping_addr2")
    val address2: String
)
