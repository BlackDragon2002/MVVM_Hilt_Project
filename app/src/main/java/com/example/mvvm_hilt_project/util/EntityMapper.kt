package com.example.mvvm_hilt_project.util

interface EntityMapper<Entity,DomainModel> {
    fun mapFromEntity(entity: Entity) :DomainModel
    fun mapToEntity(domainModel: DomainModel) :Entity
}