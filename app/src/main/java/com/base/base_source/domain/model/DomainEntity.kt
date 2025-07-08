package com.base.base_source.domain.model

data class DomainEntity(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val ipAddress: String
) {
    val fullName: String
        get() = "$firstName $lastName"
    
    val isValidEmail: Boolean
        get() = email.contains("@") && email.contains(".")
}