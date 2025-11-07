package org.multipaz.crypto

class CryptoConfig {
    companion object {
        val cryptoType = CryptoType.PQC
    }
}

enum class CryptoType {
    CLASSIC,
    PQC
}