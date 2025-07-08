package com.base.base_source.data.mapper

import com.base.base_source.data.entities.Entity
import com.base.base_source.domain.model.DomainEntity

object EntityMapper {
    fun mapToDomain(entity: Entity): DomainEntity {
        return DomainEntity(
            id = entity.id,
            firstName = entity.firstName,
            lastName = entity.lastName,
            gender = entity.gender,
            email = entity.email,
            ipAddress = entity.ipAddress
        )
    }
    
    fun mapToData(domainEntity: DomainEntity): Entity {
        return Entity(
            id = domainEntity.id,
            firstName = domainEntity.firstName,
            lastName = domainEntity.lastName,
            gender = domainEntity.gender,
            email = domainEntity.email,
            ipAddress = domainEntity.ipAddress
        )
    }
    
    fun mapToDomainList(entities: List<Entity>): List<DomainEntity> {
        return entities.map { mapToDomain(it) }
    }
    
    fun mapToDataList(domainEntities: List<DomainEntity>): List<Entity> {
        return domainEntities.map { mapToData(it) }
    }
}