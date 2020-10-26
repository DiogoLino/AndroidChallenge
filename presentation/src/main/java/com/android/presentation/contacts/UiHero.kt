package com.android.presentation.contacts

import android.os.Parcelable
import com.android.repository.contacts.models.Hero
import com.android.repository.contacts.models.HeroThumbnail
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiHero(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnailPath: UiHeroThumbnail,
    val offset: Int,
    val squadMember: Boolean = false,
    val shouldShowSquad: Boolean = false
) : Parcelable {

    fun getThumbnail(type: String): String {
        return thumbnailPath.path.toHttpsPrefix() + type + thumbnailPath.extension
    }

    // image don't load with secure source
    private fun String.toHttpsPrefix(): String? =
        if (isNotEmpty() && !startsWith("https://") && !startsWith("http://")) {
            "https://$this"
        } else if (startsWith("http://")) {
            replace("http://", "https://")
        } else this

}

fun UiHero.toDomain() = Hero(
    id = id,
    name = name,
    description = description,
    thumbnailPath = thumbnailPath.toDomain(),
    offset = offset,
    squadMember = squadMember
)

private fun UiHeroThumbnail.toDomain() = HeroThumbnail(
    path = path,
    extension = extension
)

