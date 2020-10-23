@file:JvmName("ComponentMerger")

package com.android.androidchallenge

import com.android.base_di.FeatureComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import java.util.Collections

fun <T> merge(vararg components: FeatureComponent): DispatchingAndroidInjector<T> =
    DispatchingAndroidInjector_Factory.newInstance(
        mergeMaps(components.map { it.bindings }),
        emptyMap()
    )

private fun <K, V> mergeMaps(maps: List<Map<K, V>>): Map<K, V> {
    val mergedMap: MutableMap<K, V> = HashMap()
    for (map in maps) {
        mergedMap.putAll(map)
    }
    return Collections.unmodifiableMap(mergedMap)
}
