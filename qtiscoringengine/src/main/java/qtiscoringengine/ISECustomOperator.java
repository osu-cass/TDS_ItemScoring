/*******************************************************************************
 * Educational Online Test Delivery System 
 * Copyright (c) 2014 American Institutes for Research
 *     
 * Distributed under the AIR Open Source License, Version 1.0 
 * See accompanying file AIR-License-1_0.txt or at
 * 
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package qtiscoringengine;

import org.jdom2.Attribute;
import org.jdom2.Element;

import tds.itemscoringengine.IItemScorer;

/*
 * Shiva: This class originally existed in the .NET code in itemscoringengine
 * project. As of now that code has already been ported. However, to make this
 * project completely self contained these classes have been moved to here. To
 * update these please look in itemscoringengine project. In .NET
 * ItemScoringEngine is a separate project than QTIScoringEngine but that is not
 * the case for OSS and hence for us this is a better organization.
 */
public class ISECustomOperator implements ICustomOperatorFactory
{
  private IItemScorer _externalScorer;

  public ISECustomOperator (IItemScorer externalScorer) {
    _externalScorer = externalScorer;
  }

  public boolean supportsOperator (Element customOperatorNode) {
    Element coElement = customOperatorNode;
    Attribute classAttribute = coElement.getAttribute ("class");
    if (classAttribute == null)
      return false;
    return _externalScorer.GetScorerInfo (classAttribute.getValue ()) != null;
  }

  public Expression createExpression (Element customOperatorNode) {
    return new ISECustomExpression (customOperatorNode, _externalScorer);
  }
}
