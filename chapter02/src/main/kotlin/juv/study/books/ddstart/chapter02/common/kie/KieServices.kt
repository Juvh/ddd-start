package juv.study.books.ddstart.chapter02.common.kie

class KieServices {
    companion object Factory {
        fun get(): KieService {
            return object : KieService {
                override fun getKieClassPathContainer(): KieContainer {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}
