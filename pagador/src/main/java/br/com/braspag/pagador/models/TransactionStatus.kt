package br.com.braspag.pagador.models

enum class TransactionStatus(val code: Int) {
    NotFinished(0),
    Authorized(1),
    PaymentConfirmed(2),
    Denied(3),
    Voided(10),
    Refunded(11),
    Pending(12),
    Aborted(13),
    Scheduled(20)
}