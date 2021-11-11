package com.example.mvvm_hilt_project.retrofit

import com.example.mvvm_hilt_project.model.Blog
import com.example.mvvm_hilt_project.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() :EntityMapper<BlogNetworkEntity,Blog>
{
    override fun mapFromEntity(entity: BlogNetworkEntity): Blog {
        return Blog(
            id=entity.id,
            title = entity.title,
            body = entity.body,
            category = entity.category,
            image = entity.image
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id=domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            category = domainModel.category,
            image = domainModel.image
        )
    }
    fun mapFromEntityList(entities:List<BlogNetworkEntity>):List<Blog>{
        return entities.map{mapFromEntity(it)}
    }
}