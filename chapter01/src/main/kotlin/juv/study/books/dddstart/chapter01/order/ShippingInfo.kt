package juv.study.books.dddstart.chapter01.order

class ShippingInfo(
    val receiver: Receiver,
    val address: Address
) {
    class Receiver(val name: String, val phoneNumber: String)
    class Address(val address1: String, val address2: String, val zipcode: String)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShippingInfo

        if (receiver != other.receiver) return false
        if (address != other.address) return false

        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = receiver.hashCode()
        result = prime * result + address.hashCode()
        return result
    }


}
