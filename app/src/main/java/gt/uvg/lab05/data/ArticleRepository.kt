package gt.uvg.lab05.data

import gt.uvg.lab05.model.Article

object ArticleRepository {
    fun getList() = listOf(
        Article(
            author = "Abigail Escobar",
            title = "Smart Baggage System (SBS): AI-Powered Load Security",
            excerpt = "Una arquitectura técnica para el Airbus Fly Your Ideas 2026 enfocada en la seguridad comercial.",
            readingMinutes = 5,
            date = "12 mar",
            isAuthorFollowed = false,
            isFeatured = true
        ),
        Article(
            author = "Daniel Escobar",
            title = "Tecnologías viables en agricultura",
            excerpt = "En agricultura se requieren muchos elementos de IoT para un correcto funcionamiento.",
            readingMinutes = 8,
            date = "9 ago",
            isAuthorFollowed = true,
            isFeatured = false
        ),
        Article(
            author = "Eiceny Sandoval",
            title = "ChatGPT y su uso en programación",
            excerpt = "Muchos estudiantes dependen de la IA para programar, cuando realmente debería de ser una herramienta",
            readingMinutes = 14,
            date = "3 jul",
            isAuthorFollowed = true,
            isFeatured = false
        )
    )
}