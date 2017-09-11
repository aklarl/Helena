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
package eu.ascens.generator.jHelena;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Helper class for setting string variables in template expressions
 * with void as return value
 * <p>For the example <br>
 * <code>
 * (1) «var someString = "First"»	//Prints nothing <br>
 * (2) «someString = "Second"»		//Prints "Second"<br>
 * </code>
 * the code in line 2 prints/returns the value "Second", as in Xtend template
 * expressions "everything is a value".
 * </p>
 * <p>
 * If the StringValue class is used instead, this behavior can be prevented: <br>
 * <code>
 * (1) «var StringValue someString = new StringValue("First");	//Prints nothing <br>
 * (2) «someString.setValue("Second")							//Prints nothing <br>
 * (3) «someString.value»										//Prints "Second" <br>
 * </code>
 * </p>
 */
@SuppressWarnings("all")
public class StringValueContainer {
  @Accessors
  private String stringValue;
  
  public StringValueContainer(final String stringValue) {
    this.stringValue = stringValue;
  }
  
  public void setValue(final String newVal) {
    this.stringValue = newVal;
  }
  
  public String getValue() {
    return this.stringValue;
  }
  
  @Pure
  public String getStringValue() {
    return this.stringValue;
  }
  
  public void setStringValue(final String stringValue) {
    this.stringValue = stringValue;
  }
}
