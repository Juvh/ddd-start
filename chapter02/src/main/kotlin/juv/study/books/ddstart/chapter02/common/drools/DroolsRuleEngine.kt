package juv.study.books.ddstart.chapter02.common.drools

import juv.study.books.ddstart.chapter02.common.kie.KieContainer
import juv.study.books.ddstart.chapter02.common.kie.KieServices
import juv.study.books.ddstart.chapter02.common.kie.KieSession

class DroolsRuleEngine(
    private val kContainer: KieContainer = KieServices.Factory.get().getKieClassPathContainer()
) {

    fun evaluate(sessionName: String, facts: List<*>) {
        val kSession: KieSession = kContainer.newKieSession(sessionName)
        try {
            facts.forEach(kSession::insert)
            kSession.fireAllRules()
        } finally {
            kSession.dispose()
        }
    }
}