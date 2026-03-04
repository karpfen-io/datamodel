/**
 * Copyright 2026 Karl Kegel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package instance

import meta.SimpleProperty
import meta.SimplePropertyType

/**
 * Base class for simple (primitive) property instances in a DataObject.
 *
 * @property ofType The SimpleProperty definition from the metamodel.
 * @property key The property name.
 */
abstract class SimplePropertyObject(
    val ofType: SimpleProperty,
    val key: String
){

    /**
     * Checks if this property holds multiple values.
     *
     * @return True if this is a list property.
     */
    abstract fun isList(): Boolean

    /**
     * Gets the primitive type of this property.
     *
     * @return The SimplePropertyType enum value.
     */
    fun getValueType(): SimplePropertyType {
        return ofType.propertyType
    }

    fun isBoolean(): Boolean {
        return getValueType() == SimplePropertyType.BOOLEAN
    }

    fun isString(): Boolean {
        return getValueType() == SimplePropertyType.STRING
    }

    fun isNumber(): Boolean {
        return getValueType() == SimplePropertyType.NUMBER
    }
}