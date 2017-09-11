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

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Helper {
  /**
   * Return the iterable without duplicate entries
   */
  public static <T extends Object> Iterable<T> removeDuplicates(final Iterable<T> iter) {
    return IterableExtensions.<T>toSet(iter);
  }
  
  /**
   * Returns a String, containing all elements of list and s, separated by separator
   */
  public static String joinToString(final String separator, final List<String> list, final String... s) {
    final List<String> allElements = new ArrayList<String>(list);
    List<String> _list = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(s)));
    allElements.addAll(_list);
    Joiner _on = Joiner.on(separator);
    return _on.join(allElements);
  }
  
  public static String getFirstPartOfPath(final String path, final String separator) {
    boolean _equals = Objects.equal(separator, ".");
    if (_equals) {
      String[] _split = path.split("\\.");
      return IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
    } else {
      String[] _split_1 = path.split(separator);
      return IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split_1)));
    }
  }
  
  /**
   * Takes a list as a string, that contains separators;
   * Returns the string with last element (regarding to separator) with first letter uppercase
   * e.g. example.com.test --> example.com.Test
   */
  public static String lastElemToFirstUpper(final String list, final String separator) {
    String resultString = "";
    String[] _split = list.split(separator);
    final List<String> elemList = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(_split)));
    int _length = ((Object[])Conversions.unwrapArray(elemList, Object.class)).length;
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
    for (final Integer i : _doubleDotLessThan) {
      int _length_1 = ((Object[])Conversions.unwrapArray(elemList, Object.class)).length;
      int _minus = (_length_1 - 1);
      boolean _equals = ((i).intValue() == _minus);
      if (_equals) {
        String _get = elemList.get((i).intValue());
        String _firstUpper = StringExtensions.toFirstUpper(_get);
        String _plus = (resultString + _firstUpper);
        resultString = _plus;
      } else {
        String _get_1 = elemList.get((i).intValue());
        String _plus_1 = (resultString + _get_1);
        String _plus_2 = (_plus_1 + separator);
        resultString = _plus_2;
      }
    }
    return resultString;
  }
  
  /**
   * compares two lists
   */
  public static <C extends Object> boolean equals(final List<C> list1, final List<C> list2) {
    if (((Objects.equal(list1, null) && Objects.equal(list2, null)) || ((list1.size() == 0) && (list2.size() == 0)))) {
      return true;
    }
    int _size = list1.size();
    int _size_1 = list2.size();
    boolean _notEquals = (_size != _size_1);
    if (_notEquals) {
      return false;
    }
    int _size_2 = list1.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        C first = list1.get((i).intValue());
        C second = list2.get((i).intValue());
        boolean _notEquals_1 = (!Objects.equal(first, second));
        if (_notEquals_1) {
          return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Adds the element to the collection if it is not already contained according to the given equals function
   */
  public static <T extends Object> Collection<T> addAllDuplicateFree(final Collection<T> list, final Collection<T> toBeAdded, final Function2<T, T, Boolean> equals) {
    for (final T elem1 : toBeAdded) {
      final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
        @Override
        public Boolean apply(final T it) {
          Boolean _apply = equals.apply(elem1, it);
          return Boolean.valueOf((!(_apply).booleanValue()));
        }
      };
      boolean _forall = IterableExtensions.<T>forall(list, _function);
      if (_forall) {
        list.add(elem1);
      }
    }
    return list;
  }
  
  /**
   * Adds all elements of the second collection to the first one if it is not already contained according to the given equals function
   */
  public static <T extends Object> Collection<T> addDuplicateFree(final Collection<T> list, final T elem, final Function2<T, T, Boolean> equals) {
    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
      @Override
      public Boolean apply(final T it) {
        Boolean _apply = equals.apply(elem, it);
        return Boolean.valueOf((!(_apply).booleanValue()));
      }
    };
    boolean _forall = IterableExtensions.<T>forall(list, _function);
    if (_forall) {
      list.add(elem);
    }
    return list;
  }
  
  /**
   * Returns an element as a List
   */
  public static <T extends Object> Collection<T> asList(final T elem) {
    ArrayList<T> list = new ArrayList<T>();
    list.add(elem);
    return list;
  }
}
