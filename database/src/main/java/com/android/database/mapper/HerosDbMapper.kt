package com.android.database.mapper

import com.android.database.model.entities.HeroAvatarDb
import com.android.database.model.entities.HeroesEntity
import com.android.repository.contacts.models.Hero
import com.android.repository.contacts.models.HeroThumbnail

fun Hero.toEntity() = HeroesEntity(
    id = id,
    name = name,
    description = description,
    offset = offset,
    thumbnail = thumbnailPath.toEntity(),
    squadMember = squadMember
)

fun HeroThumbnail.toEntity() = HeroAvatarDb(
    path = path,
    extension = extension
)

fun HeroesEntity.toDomain() = Hero(
    id = id,
    name = name,
    description = description,
    offset = offset,
    thumbnailPath = thumbnail.toDomain(),
    squadMember = squadMember,
    shouldShowSquad = false

)

fun HeroAvatarDb.toDomain() = HeroThumbnail(
    path = path,
    extension = extension
)