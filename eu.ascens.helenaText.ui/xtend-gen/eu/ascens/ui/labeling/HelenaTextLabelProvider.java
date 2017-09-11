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
package eu.ascens.ui.labeling;

import com.google.inject.Inject;
import eu.ascens.helenaText.AbstractAssignment;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.MsgDirection;
import eu.ascens.helenaText.RoleBehavior;
import eu.ascens.helenaText.RoleType;
import eu.ascens.helenaText.RoleTypeWithMultiplicity;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class HelenaTextLabelProvider extends XbaseLabelProvider {
  @Inject
  public HelenaTextLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final AbstractAssignment a) {
    RoleType _roleTypeRef = a.getRoleTypeRef();
    return _roleTypeRef.getName();
  }
  
  public String text(final RoleTypeWithMultiplicity rtWithMult) {
    RoleType _roleType = rtWithMult.getRoleType();
    String _name = _roleType.getName();
    String _plus = ("<" + _name);
    String _plus_1 = (_plus + ",");
    String _min = rtWithMult.getMin();
    Object _text = this.text(_min);
    String _plus_2 = (_plus_1 + _text);
    String _plus_3 = (_plus_2 + ",");
    String _max = rtWithMult.getMax();
    Object _text_1 = this.text(_max);
    String _plus_4 = (_plus_3 + _text_1);
    String _plus_5 = (_plus_4 + ",");
    int _capacity = rtWithMult.getCapacity();
    Object _text_2 = this.text(Integer.valueOf(_capacity));
    String _plus_6 = (_plus_5 + _text_2);
    return (_plus_6 + ">");
  }
  
  public String text(final RoleBehavior rb) {
    RoleType _roleTypeRef = rb.getRoleTypeRef();
    String _name = _roleTypeRef.getName();
    return (_name + " (role behavior)");
  }
  
  public String text(final MessageType msgType) {
    MsgDirection _direction = msgType.getDirection();
    String _plus = (_direction + " ");
    String _name = msgType.getName();
    return (_plus + _name);
  }
}
