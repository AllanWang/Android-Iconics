/*
 * Copyright (c) 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mikepenz.iconics.typeface.library.meteoconcs

import android.content.Context
import android.graphics.Typeface
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.LinkedList
import kotlin.collections.HashMap

@Suppress("EnumEntryName", "LeakingThis")
class Meteoconcs : ITypeface {

    override val characters: HashMap<String, Char>
        get() {
            if (chars == null) {
                val aChars = HashMap<String, Char>()
                Icon.values().associateTo(aChars) { it.name to it.character }
                chars = aChars
            }
            return chars!!
        }

    override val mappingPrefix: String
        get() = "met"

    override val fontName: String
        get() = "Meteocons"

    override val version: String
        get() = "1.1.1"

    override val iconCount: Int
        get() = characters.size

    override val icons: Collection<String>
        get() = Icon.values().map { it.name }.toCollection(LinkedList())

    override val author: String
        get() = "Alessio Atzeni"

    override val url: String
        get() = "http://www.alessioatzeni.com/meteocons/"

    override val description: String
        get() = "Meteocons is a set of weather icons, it containing 40+ icons available in PSD, CSH, EPS, SVG, Desktop font and Web font. All icon and updates are free and always will be."

    override val license: String
        get() = ""

    override val licenseUrl: String
        get() = ""

    override fun getIcon(key: String): IIcon {
        return Icon.valueOf(key)
    }

    override fun getTypeface(ctx: Context): Typeface {
        if (typeface == null) {
            typeface = try {
                Typeface.createFromAsset(ctx.assets, "fonts/$TTF_FILE")
            } catch (e: Exception) {
                Typeface.DEFAULT
            }
        }
        return typeface!!
    }

    enum class Icon constructor(character: Char) : IIcon {
        met_windy_rain_inv('\ue800'),
        met_snow_inv('\ue801'),
        met_snow_heavy_inv('\ue802'),
        met_hail_inv('\ue803'),
        met_clouds_inv('\ue804'),
        met_clouds_flash_inv('\ue805'),
        met_temperature('\ue806'),
        met_compass('\ue807'),
        met_na('\ue808'),
        met_celcius('\ue809'),
        met_fahrenheit('\ue80a'),
        met_clouds_flash_alt('\ue80b'),
        met_sun_inv('\ue80c'),
        met_moon_inv('\ue80d'),
        met_cloud_sun_inv('\ue80e'),
        met_cloud_moon_inv('\ue80f'),
        met_cloud_inv('\ue810'),
        met_cloud_flash_inv('\ue811'),
        met_drizzle_inv('\ue812'),
        met_rain_inv('\ue813'),
        met_windy_inv('\ue814'),
        met_sunrise('\ue815'),
        met_sun('\ue816'),
        met_moon('\ue817'),
        met_eclipse('\ue818'),
        met_mist('\ue819'),
        met_wind('\ue81a'),
        met_snowflake('\ue81b'),
        met_cloud_sun('\ue81c'),
        met_cloud_moon('\ue81d'),
        met_fog_sun('\ue81e'),
        met_fog_moon('\ue81f'),
        met_fog_cloud('\ue820'),
        met_fog('\ue821'),
        met_cloud('\ue822'),
        met_cloud_flash('\ue823'),
        met_cloud_flash_alt('\ue824'),
        met_drizzle('\ue825'),
        met_rain('\ue826'),
        met_windy('\ue827'),
        met_windy_rain('\ue828'),
        met_snow('\ue829'),
        met_snow_alt('\ue82a'),
        met_snow_heavy('\ue82b'),
        met_hail('\ue82c'),
        met_clouds('\ue82d'),
        met_clouds_flash('\ue82e');

        override var character: Char = ' '
            internal set

        init {
            this.character = character
        }

        override val typeface: ITypeface
            get() = savedTypeface

        companion object {
            // remember the typeface so we can use it later
            private val savedTypeface: ITypeface by lazy { Meteoconcs() }
        }
    }

    companion object {
        private const val TTF_FILE = "meteocons-v1.1.1.ttf"
        private var typeface: Typeface? = null
        private var chars: HashMap<String, Char>? = null
    }
}
