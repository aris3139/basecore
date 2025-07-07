package com.base.base_source.data.mapper

import com.base.base_source.data.entities.Entity
import com.base.base_source.domain.model.User

fun Entity.toDomainModel(): User {
    return User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        gender = gender,
        email = email,
        ipAddress = ipAddress
    )
}

fun List<Entity>.toDomainModel(): List<User> {
    return map { it.toDomainModel() }
}