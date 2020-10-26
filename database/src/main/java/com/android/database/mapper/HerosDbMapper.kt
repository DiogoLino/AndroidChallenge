package com.android.database.mapper

import com.android.database.model.entities.HeroesEntity
import com.android.repository.contacts.models.Hero


fun Hero.toEntity() = HeroesEntity(
    id = id,
    name = name,
    description = description,
    offset = offset,
    thumbnailPath = thumbnailPath,
    squadMember = squadMember
)

//
//fun Heroes.toDomain() : HeroesEntity{
//    if = id,
//    name = name,
//
//}