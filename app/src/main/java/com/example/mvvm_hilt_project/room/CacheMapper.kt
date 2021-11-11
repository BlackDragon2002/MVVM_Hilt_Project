package com.example.mvvm_hilt_project.room

import com.example.mvvm_hilt_project.model.Blog
import com.example.mvvm_hilt_project.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<BlogCacheEntity,Blog>
{
    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
         return Blog(
             id = entity.id,
             body = entity.body,
             category = entity.category,
             image = entity.image,
             title = entity.title
         )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            category = domainModel.category,
            body = domainModel.body,
            image = domainModel.image
        )
    }
    fun mapFromEntityList(entities:List<BlogCacheEntity>) = entities.map { mapFromEntity(it) }
}