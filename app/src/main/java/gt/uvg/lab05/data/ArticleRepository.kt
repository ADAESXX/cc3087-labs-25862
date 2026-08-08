package gt.uvg.lab05.data

import gt.uvg.lab05.model.Article

object ArticleRepository {
    fun getList() = listOf(
        Article(
            name = "Abigail Escobar",
            title = "Smart Baggage System (SBS): AI-Powered Load Security",
            resume = "Una arquitectura técnica para el Airbus Fly Your Ideas 2026 enfocada en la seguridad comercial.",
            readTime = 5,
            creationDate = "12 mar"
        ),
        Article(
            name = "Daniel Escobar",
            title = "Tecnologías viables en agricultura",
            resume = "En agricultura se requieren muchos elementos de IoT para un correcto funcionamiento.",
            readTime = 8,
            creationDate = "9 ago"
        ),
        Article(
            name = "Eiceny Sandoval",
            title = "ChatGPT y su uso en programación",
            resume = "Muchos estudiantes dependen de la IA para programar, cuando realmente debería de ser una herramienta",
            readTime = 4,
            creationDate = "3 jul"
        )
    )
}