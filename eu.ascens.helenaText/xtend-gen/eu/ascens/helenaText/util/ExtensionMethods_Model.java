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
import eu.ascens.helenaText.FormalDataParam;
import eu.ascens.helenaText.FormalDataParamsBlock;
import eu.ascens.helenaText.FormalRoleParam;
import eu.ascens.helenaText.FormalRoleParamsBlock;
import eu.ascens.helenaText.MessageType;
import eu.ascens.helenaText.Model;
import eu.ascens.helenaText.PackageDeclaration;
import eu.ascens.helenaText.RoleType;
import org.eclipse.emf.common.util.EList;

@SuppressWarnings("all")
public class ExtensionMethods_Model {
  /**
   * Returns the maximal number of role params in any message in the model
   */
  public static int maxNumberOfRoleParamsInModel(final Model model) {
    return ExtensionMethods_Model.maxNumberOfAbstractParamsInModel(model, FormalRoleParamsBlock.class);
  }
  
  /**
   * Returns the maximal number of data params in any message in the model
   */
  public static int maxNumberOfDataParamsInModel(final Model model) {
    return ExtensionMethods_Model.maxNumberOfAbstractParamsInModel(model, FormalDataParamsBlock.class);
  }
  
  private static int maxNumberOfAbstractParamsInModel(final Model model, final Class<?> clazz) {
    int maxNumber = 1;
    PackageDeclaration _headPkg = model.getHeadPkg();
    EList<RoleType> _roleTypes = _headPkg.getRoleTypes();
    for (final RoleType rt : _roleTypes) {
      EList<MessageType> _rolemsgs = rt.getRolemsgs();
      for (final MessageType msg : _rolemsgs) {
        {
          int currentNumber = 0;
          boolean _matched = false;
          if (Objects.equal(clazz, FormalRoleParamsBlock.class)) {
            _matched=true;
            FormalRoleParamsBlock _formalRoleParamsBlock = msg.getFormalRoleParamsBlock();
            EList<FormalRoleParam> _params = _formalRoleParamsBlock.getParams();
            int _size = _params.size();
            currentNumber = _size;
          }
          if (!_matched) {
            if (Objects.equal(clazz, FormalDataParamsBlock.class)) {
              _matched=true;
              FormalDataParamsBlock _formalDataParamsBlock = msg.getFormalDataParamsBlock();
              EList<FormalDataParam> _params_1 = _formalDataParamsBlock.getParams();
              int _size_1 = _params_1.size();
              currentNumber = _size_1;
            }
          }
          if ((currentNumber > maxNumber)) {
            maxNumber = currentNumber;
          }
        }
      }
    }
    return maxNumber;
  }
}
