package juv.study.books.dddstart.chapter04.shop.common

import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class MoneyConverter : AttributeConverter<Money?, Int?> {
    override fun convertToDatabaseColumn(attribute: Money?): Int? = attribute?.amounts

    override fun convertToEntityAttribute(dbData: Int?): Money? = dbData?.let { Money(amounts = it) }
}