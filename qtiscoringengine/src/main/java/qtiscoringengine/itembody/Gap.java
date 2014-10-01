/*******************************************************************************
 * Educational Online Test Delivery System 
 * Copyright (c) 2014 American Institutes for Research
 *   
 * Distributed under the AIR Open Source License, Version 1.0 
 * See accompanying file AIR-License-1_0.txt or at
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package qtiscoringengine.itembody;

import org.jdom2.Element;

import qtiscoringengine.ValidationLog;
import AIR.Common.xml.XmlNamespaceManager;

class Gap extends SimpleChoice
{
  protected Gap (String identifier) {
    super (identifier);
  }

  static/* new */Gap fromXml (Element element, XmlNamespaceManager nsmgr, ValidationLog log)
  {
    String identifier = element.getAttributeValue (ItemBodyConstants.Identifier);
    return new Gap (identifier);
  }
}
