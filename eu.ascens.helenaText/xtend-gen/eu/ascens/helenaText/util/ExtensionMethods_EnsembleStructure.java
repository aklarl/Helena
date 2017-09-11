/**
 * The Helena workbench is an Eclipse plugin for the development of ensemble-based systems
 *  according to the Helena approach. It is fully documented in the PhD
 *  thesis "Helena - Handling massively distributed systems with ELaborate
 *  ENsemble Architectures" by Annabelle Klarl in 2016.
 * 
 *  Website: http://www.pst.ifi.lmu.de/Personen/team/klarl/helena.html
 *  PhD thesis: https://edoc.ub.uni-muenchen.de/20087/
 * 
 *  Copyright (C) 2013-2017  Annabelle Klarl
 *  All rights reserved.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.ascens.helenaText.util;

import com.google.common.base.Objects;
import eu.ascens.helenaText.EnsembleStructure;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import org.eclipse.emf.common.util.EList;

@SuppressWarnings("all")
public class ExtensionMethods_EnsembleStructure {
  /**
   * Calculates the multiplicity from an ensemble structure for a role type as
   * value (if only one value was set) or the maximum from the range
   * If maximum is "*" Integer.MAX_VALUE is returned
   * @return maximum multiplicity for a role type
   */
  public static String getMaxMultiplicityForRoleType(final EnsembleStructure es, final RoleType rt) {
    EList<RoleTypeWithMultiplicity> _rtWithMult = es.getRtWithMult();
    for (final RoleTypeWithMultiplicity rtWithMult : _rtWithMult) {
      RoleType _roleType = rtWithMult.getRoleType();
      boolean _equals = Objects.equal(_roleType, rt);
      if (_equals) {
        String _max = rtWithMult.getMax();
        return ExtensionMethods_EnsembleStructure.calculateMultiplicityJava(_max);
      }
    }
    return null;
  }
  
  /**
   * @return capacity for a role type
   */
  public static Integer getCapacityForRoleType(final EnsembleStructure es, final RoleType rt) {
    EList<RoleTypeWithMultiplicity> _rtWithMult = es.getRtWithMult();
    for (final RoleTypeWithMultiplicity rtWithMult : _rtWithMult) {
      RoleType _roleType = rtWithMult.getRoleType();
      boolean _equals = Objects.equal(_roleType, rt);
      if (_equals) {
        return Integer.valueOf(rtWithMult.getCapacity());
      }
    }
    return null;
  }
  
  private static String calculateMultiplicityJava(final String multiplicity) {
    boolean _equals = Objects.equal(multiplicity, "*");
    if (_equals) {
      return "Integer.MAX_VALUE";
    } else {
      return multiplicity;
    }
  }
  
  public static String calculateMultiplicityPromela(final String multiplicity) {
    boolean _equals = Objects.equal(multiplicity, "*");
    if (_equals) {
      return "(2^31)-1";
    } else {
      return multiplicity;
    }
  }
}
