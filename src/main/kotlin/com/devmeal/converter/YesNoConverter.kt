package com.devmeal.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = false)
class YesNoConverter : AttributeConverter<Boolean, String> {

    override fun convertToDatabaseColumn(attribute: Boolean?): String {
        return if (attribute == true) "Y" else "N"
    }

    override fun convertToEntityAttribute(dbData: String?): Boolean {
        return dbData.equals("Y", ignoreCase = true)
    }
}