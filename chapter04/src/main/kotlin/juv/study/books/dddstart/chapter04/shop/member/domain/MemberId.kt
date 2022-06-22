package juv.study.books.dddstart.chapter04.shop.member.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class MemberId(
    @Column(name = "member_id")
    val id: String
) : java.io.Serializable
