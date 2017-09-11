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
package eu.ascens.validation;

import eu.ascens.helenaText.HelenaTextPackage;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import eu.ascens.validation.HelenaTextValidator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class EnsembleStructureValidator extends AbstractDeclarativeValidator {
  @Override
  public void register(final EValidatorRegistrar registrar) {
  }
  
  /**
   * Checks for a multiplicity in an ensemble structure
   * if the first number in a range is smaller than the second
   */
  @Check
  public Object check_ensembleStructure_multiplicity_firstRangeValSmallerThanSecond(final RoleTypeWithMultiplicity rtMult) {
    Object _xblockexpression = null;
    {
      int min = 0;
      int max = 0;
      try {
        String _min = rtMult.getMin();
        int _parseInt = Integer.parseInt(_min);
        min = _parseInt;
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
          final NumberFormatException e = (NumberFormatException)_t;
          try {
            String _max = rtMult.getMax();
            Integer.parseInt(_max);
            this.error(
              "First value in the range has to be smaller than the second one.", 
              HelenaTextPackage.Literals.ROLE_TYPE_WITH_MULTIPLICITY__MAX, 
              HelenaTextValidator.MULT_RANGE_WRONG);
          } catch (final Throwable _t_1) {
            if (_t_1 instanceof NumberFormatException) {
              final NumberFormatException e2 = (NumberFormatException)_t_1;
            } else {
              throw Exceptions.sneakyThrow(_t_1);
            }
          }
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Object _xtrycatchfinallyexpression = null;
      try {
        String _max_1 = rtMult.getMax();
        int _parseInt_1 = Integer.parseInt(_max_1);
        max = _parseInt_1;
        if ((min > max)) {
          this.error(
            "First value in the range has to be smaller than the second one.", 
            HelenaTextPackage.Literals.ROLE_TYPE_WITH_MULTIPLICITY__MAX, 
            HelenaTextValidator.MULT_RANGE_WRONG);
        }
      } catch (final Throwable _t_2) {
        if (_t_2 instanceof NumberFormatException) {
          final NumberFormatException e_1 = (NumberFormatException)_t_2;
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t_2);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
}
