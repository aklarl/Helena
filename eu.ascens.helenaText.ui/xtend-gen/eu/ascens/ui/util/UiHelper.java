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
package eu.ascens.ui.util;

import com.google.common.base.Joiner;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;

@SuppressWarnings("all")
public class UiHelper {
  public static String getFormalParamsAsString(final List<String> types, final List<String> names, final String separator) {
    StringBuilder sb = new StringBuilder();
    int _length = ((Object[])Conversions.unwrapArray(types, Object.class)).length;
    int _length_1 = ((Object[])Conversions.unwrapArray(names, Object.class)).length;
    boolean _notEquals = (_length != _length_1);
    if (_notEquals) {
      return "";
    } else {
      int _length_2 = ((Object[])Conversions.unwrapArray(names, Object.class)).length;
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length_2, true);
      for (final Integer k : _doubleDotLessThan) {
        {
          if (((k).intValue() != 0)) {
            sb.append(separator);
          }
          String _get = types.get((k).intValue());
          String _plus = (_get + " ");
          String _get_1 = names.get((k).intValue());
          String _plus_1 = (_plus + _get_1);
          sb.append(_plus_1);
        }
      }
    }
    return sb.toString();
  }
  
  public static String getFormalParamNamesAsString(final List<String> names, final String separator) {
    Joiner _on = Joiner.on(separator);
    Joiner joiner = _on.skipNulls();
    return joiner.join(names);
  }
}
