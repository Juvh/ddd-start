package juv.study.books.dddstart.chapter04.shop.catalog.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class ProductId(
    @Column(name = "product_id")
    val id: String
)
