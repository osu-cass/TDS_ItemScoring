/*******************************************************************************
 * Educational Online Test Delivery System 
 * Copyright (c) 2014 American Institutes for Research
 *     
 * Distributed under the AIR Open Source License, Version 1.0 
 * See accompanying file AIR-License-1_0.txt or at
 * 
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 ******************************************************************************/
package tinyequationscoringengine;

import java.util.List;

import org.jdom2.Element;

import qtiscoringengine.DEBoolean;
import qtiscoringengine.DEIdentifier;
import qtiscoringengine.DEInteger;
import qtiscoringengine.DEString;
import qtiscoringengine.DataElement;
import qtiscoringengine.ExpressionAttributeSpec;
import qtiscoringengine.BaseType;
import qtiscoringengine.Cardinality;
import qtiscoringengine.QTIRubric;
import qtiscoringengine.QTIScoringException;
import qtiscoringengine.VariableBindings;

public class TEEqLineContains extends TinyEqExpression
{
  public TEEqLineContains (Element node) {
    super (node, 0, 0, BaseType.Boolean, Cardinality.Single);
    addAttribute (new ExpressionAttributeSpec ("object", BaseType.Identifier, false));
    addAttribute (new ExpressionAttributeSpec ("exemplar", BaseType.String, false));
    addAttribute (new ExpressionAttributeSpec ("simplify", BaseType.Boolean, false));

    addEqParameterConstraint ("object", TinyEquation.TEType.Expression);
    addEqParameterConstraint ("exemplar", TinyEquation.TEType.Expression);
  }

  protected DataElement exprEvaluate (VariableBindings vb, QTIRubric rubric, List<DataElement> paramValues) throws QTIScoringException {
    DEString obj = (DEString) vb.getVariable ((DEIdentifier) getAttributeValue ("object"));
    if (obj == null)
      obj = new DEString ("");
    DEString expr = (DEString) vb.getVariable (getAttributeValue ("exemplar").toString ());
    if (expr == null)
      expr = (DEString) getAttributeValue ("exemplar");
    DEBoolean simplify = (DEBoolean) getAttributeValue ("simplify");
    return new DEBoolean (TinyEquation.lineContainsEquivalent (obj.toString (), expr.toString (), simplify.getBooleanValue (), false, false, false));
  }
}
