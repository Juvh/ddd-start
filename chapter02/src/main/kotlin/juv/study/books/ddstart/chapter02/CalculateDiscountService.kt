package juv.study.books.ddstart.chapter02

import juv.study.books.ddstart.chapter02.common.drools.DroolsRuleEngine
import juv.study.books.ddstart.chapter02.common.money.Money
import juv.study.books.ddstart.chapter02.common.money.MutableMoney
import juv.study.books.ddstart.chapter02.domain.customer.Customer
import juv.study.books.ddstart.chapter02.domain.order.OrderLine

class CalculateDiscountService(
    private val ruleDiscounter: RuleDiscounter
    //private val ruleEngine: DroolsRuleEngine = DroolsRuleEngine()
) {
    fun calculateDiscount(orderLines: List<OrderLine>, customerId: String): Money {
        val customer: Customer = findCustomer(customerId)

        return ruleDiscounter.applyRules(customer, orderLines)

        /*
        val money = MutableMoney(0)
        val facts = mutableListOf(customer, money)
        facts.addAll(orderLines)
        ruleEngine.evaluate("discountCalculation", facts)
        return money.toImmutableMoney()
        */
    }

    private fun findCustomer(customerId: String): Customer {
        TODO("Not yet implemented")
    }
}