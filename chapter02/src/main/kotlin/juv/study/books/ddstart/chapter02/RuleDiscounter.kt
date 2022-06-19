package juv.study.books.ddstart.chapter02

import juv.study.books.ddstart.chapter02.common.money.Money
import juv.study.books.ddstart.chapter02.domain.customer.Customer
import juv.study.books.ddstart.chapter02.domain.order.OrderLine

interface RuleDiscounter {
    fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money
}