package juv.study.books.dddstart.chapter04.shop.order.domain

import javax.persistence.*

@Embeddable
data class ShippingInfo(
    @Embedded
    @AttributeOverrides(value = [
        AttributeOverride(name = "zipCode", column = Column(name = "shipping_zipcode")),
        AttributeOverride(name = "address1", column = Column(name = "shipping_addr1")),
        AttributeOverride(name = "address2", column = Column(name = "shipping_addr2"))
    ])
    val address: Address,

    @Embedded
    val receiver: Receiver
)
