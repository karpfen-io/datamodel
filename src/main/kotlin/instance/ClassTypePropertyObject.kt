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

import meta.ClassType
import meta.ClassTypeProperty

/**
 * Base class for complex object property instances in a DataObject.
 *
 * @property ofType The ClassTypeProperty definition from the metamodel.
 * @property key The property name.
 */
abstract class ClassTypePropertyObject(val ofType: ClassTypeProperty, val key: String) {

    /**
     * Checks if this property holds multiple objects.
     *
     * @return True if this is a list property.
     */
    abstract fun isList(): Boolean

    /**
     * Gets the property type definition.
     *
     * @return The ClassTypeProperty from the metamodel.
     */
    fun getPropertyType(): ClassTypeProperty {
        return ofType
    }

    /**
     * Gets the target class type name of this property.
     *
     * @return The class type name string.
     */
    fun getClassType(): String {
        return ofType.reference.classTypeName
    }
}