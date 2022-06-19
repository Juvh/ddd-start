package juv.study.books.ddstart.chapter02

import juv.study.books.ddstart.chapter02.common.kie.KieContainer
import juv.study.books.ddstart.chapter02.common.kie.KieServices
import juv.study.books.ddstart.chapter02.common.kie.KieSession
import juv.study.books.ddstart.chapter02.common.money.Money
import juv.study.books.ddstart.chapter02.common.money.MutableMoney
import juv.study.books.ddstart.chapter02.domain.customer.Customer
import juv.study.books.ddstart.chapter02.domain.order.OrderLine

class DroolsRuleDiscounter(
    private val kieContainer: KieContainer = KieServices.Factory.get().getKieClassPathContainer()
) : RuleDiscounter {

    override fun applyRules(customer: Customer, orderLines: List<OrderLine>): Money {

        val money = MutableMoney(0)
        val facts = mutableListOf(customer, money)
        facts.addAll(orderLines)

        val kSession: KieSession = kieContainer.newKieSession("discountSession")
        try {
            facts.forEach(kSession::insert)
            kSession.fireAllRules()
        } finally {
            kSession.dispose()
        }

        return money.toImmutableMoney()
    }
}