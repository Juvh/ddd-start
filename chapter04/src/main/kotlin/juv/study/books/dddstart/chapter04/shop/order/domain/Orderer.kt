package juv.study.books.dddstart.chapter04.shop.order.domain

import juv.study.books.dddstart.chapter04.shop.member.domain.MemberId
import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
data class Orderer(
    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "id", column = Column(name = "orderer_id"))
    )
    val memberId: MemberId
)
