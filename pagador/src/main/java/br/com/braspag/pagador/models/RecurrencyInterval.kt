package br.com.braspag.pagador.models

enum class RecurrencyInterval(val code: Int) {
    Monthly(1),
    Bimonthly(2),
    Quarterly(4),
    SemiAnnual(6),
    Annual(12)
}